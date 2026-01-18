import pandas as pd
import numpy as np
import plotly.graph_objects as go
from plotly.subplots import make_subplots

dates = pd.date_range(start='2025-11-01', end='2025-12-31')
regions = ['North', 'South', 'East', 'West']
categories = ['Electronics', 'Clothing', 'Home']
region_colors = {
    'North': 'blue',
    'South': 'green',
    'East': 'red',
    'West': 'orange'
}
catetory_colors = {
    'Electronics': 'purple',
    'Clothing': 'pink',
    'Home': 'brown'
}

fig = make_subplots(
    rows=2, cols=1,
    shared_xaxes=True,
    vertical_spacing=0.15,
    subplot_titles=('Regional Sales Trends', 'Category Performance')
)


def generate_sales_data():
    np.random.seed(42)
    data = []
    for date in dates:
        for region in regions:
            for category in categories:
                base = 500 + 200 * np.sin(2 * np.pi * date.dayofyear / 365)
                noise = np.random.normal(0, 50)
                sales = max(0, base + noise + 
                    {'Electronics': 300, 'Clothing': 200, 'Home': 100}[category] +
                    {'North': 100, 'South': -50, 'East': 0, 'West': 50}[region])
                data.append([date, region, category, sales])
    df = pd.DataFrame(data, columns=['date', 'region', 'category', 'sales'])
    df['month'] = df['date'].dt.to_period('M').astype(str)
    return df


def do_plot(selected_region='All'):
    df = generate_sales_data()

    if selected_region != 'All':
        filted_df = df[df['region'] == selected_region]
    else:
        filted_df = df.copy()
    
    monthly_sales = filted_df.groupby(['month', 'region'])['sales'].sum().reset_index()
    # print(monthly_sales)

    category_sales = filted_df.groupby(['region', 'category'])['sales'].sum().reset_index()
    # print(category_sales)

    for region in regions:
        region_data = monthly_sales[monthly_sales['region'] == region]
        fig.add_trace(
            go.Scatter(
                x=region_data['month'],
                y=region_data['sales'],
                mode='lines+markers',
                name=region,
                line=dict(color=region_colors[region])
            ),
            row=1, col=1
        )

    for region in regions:
        region_data = category_sales[category_sales['region'] == region]
        fig.add_trace(
            go.Bar(
                x=region_data['category'],
                y=region_data['sales'],
                name=region,
                marker={'color': region_colors[region]}
            ),
            row=2, col=1
        )

    dropdown_options = dropdown_options_config()
    fig.update_layout(
        title_text='Sales Data Analysis',
        showlegend=True,
        height=700,
        xaxis_title='Month',
        yaxis_title='Sales ($)',
        xaxis2_title='Category',
        yaxis2_title='Sales ($)',
        barmode='group',
        updatemenus=[
            dict(
                active=0,
                buttons=dropdown_options,
                x=1.1,
                y=1.15,
                xanchor='right',
                yanchor='top'
            )
        ]
    )
    fig.show()


def dropdown_options_config():
    dropdown_options = [
        dict(
            label='All',
            method='update',
            args=[{'visible': [True] * (len(regions) * 2)}]
        )
    ]
    for i, region in enumerate(regions):
        visibility = [False] * (len(regions) * 2)
        visibility[i] = True  # Line plot for the region
        visibility[i + len(regions)] = True  # Bar plot for the region
        dropdown_options.append(dict(
            label=region,
            method='update',
            args=[{'visible': visibility}]
        ))
    return dropdown_options


## Additional requirements
# 1. Add a second dropdown to switch between Monthly and Quarterly aggregation
# 2. Include a pie chart showing regional sales distribution that updates with the selections
# 3. Add ragne slider to the line chart for date filtering
def do_plot_v2(selected_region='All'):
    # enhanced plot: monthly/quarterly toggle, pie chart, range slider
    df = generate_sales_data()
    filt = df[df['region'] == selected_region] if selected_region != 'All' else df.copy()

    # time aggregations
    ts_month = filt.groupby([pd.Grouper(key='date', freq='M'), 'region'])['sales'].sum().reset_index()
    ts_quarter = filt.groupby([pd.Grouper(key='date', freq='Q'), 'region'])['sales'].sum().reset_index()

    # category and pie data (aggregated over the filtered period)
    cat_sales = filt.groupby(['region', 'category'])['sales'].sum().reset_index()

    # prepare per-region time series dicts
    month_map_x = {r: ts_month[ts_month['region'] == r]['date'].tolist() for r in regions}
    month_map_y = {r: ts_month[ts_month['region'] == r]['sales'].tolist() for r in regions}
    quarter_map_x = {r: ts_quarter[ts_quarter['region'] == r]['date'].tolist() for r in regions}
    quarter_map_y = {r: ts_quarter[ts_quarter['region'] == r]['sales'].tolist() for r in regions}

    # new subplot layout: top spans two cols, bottom has bar + pie (pie requires 'domain' subplot type)
    new_fig = make_subplots(
        rows=2, cols=2,
        specs=[[{"colspan": 2}, None], [{}, {"type": "domain"}]],
        vertical_spacing=0.35,
        # horizontal_spacing=1,
        subplot_titles=('Regional Sales Trends', 'Category Performance', 'Regional Share')
    )

    # 1) line chart
    for r in regions:
        new_fig.add_trace(
            go.Scatter(
                x=month_map_x[r],
                y=month_map_y[r],
                mode='lines+markers',
                name=r,
                line=dict(color=region_colors.get(r, None))
            ), row=1, col=1
        )

    # 2) bar chart
    for r in regions:
        rd = cat_sales[cat_sales['region'] == r]
        new_fig.add_trace(
            go.Bar(
                x=rd['category'],
                y=rd['sales'],
                name=r,
                marker={'color': region_colors.get(r, None)}
            ), row=2, col=1
        )

    # 3) Pie traces: one global regional distribution, plus one per-region category breakdown
    # All regional pie
    pie_colors = [catetory_colors.get(cat, '#CCCCCC') for cat in categories]
    new_fig.add_trace(
        go.Pie(
            labels=categories,
            values=[cat_sales[cat_sales['category'] == cat]['sales'].sum() for cat in categories],
            name='Regional Share',
            marker=dict(colors=pie_colors)
        ),
        row=2, col=2
    )
    # per-region pies (category breakdown), hidden initially
    for region in regions:
        rd = cat_sales[cat_sales['region'] == region]
        new_fig.add_trace(
            go.Pie(
                labels=rd['category'],
                values=rd['sales'],
                name=f'{region} Share',
                marker=dict(colors=pie_colors),
                visible=False
            ),
            row=2, col=2
        )

    # set axis titles and range slider for the line chart
    new_fig.update_xaxes(title_text='Date', row=1, col=1, rangeslider=dict(visible=True))
    new_fig.update_yaxes(title_text='Sales ($)', row=1, col=1)
    new_fig.update_xaxes(title_text='Category', row=2, col=1)
    new_fig.update_yaxes(title_text='Sales ($)', row=2, col=1)

    # build dropdowns
    R = len(regions)
    # trace index layout:
    # lines: 0..R-1
    # bars: R..2R-1
    # pies: 2R..2R (global) and 2R+1..2R+R (per-region)
    total_traces = 2 * R + (1 + R)

    # Region dropdown: toggles visibility of lines, bars, and selects appropriate pie
    region_buttons = []
    # All button
    vis_all = [True] * R + [True] * R + [True] + [False] * R
    region_buttons.append(dict(label='All', method='update', args=[{'visible': vis_all}]))

    for i, r in enumerate(regions):
        vis = [False] * total_traces
        vis[i] = True                         # line for region
        vis[R + i] = True                     # bar for region
        vis[2 * R] = False                    # pie
        vis[2 * R + 1 + i] = True             # region-specific pie
        region_buttons.append(dict(label=r, method='update', args=[{'visible': vis}]))

    # Aggregation dropdown: restyle line traces' x and y (does not change bars/pies visibility)
    monthly_xs = [month_map_x[r] for r in regions]
    monthly_ys = [month_map_y[r] for r in regions]
    quarterly_xs = [quarter_map_x[r] for r in regions]
    quarterly_ys = [quarter_map_y[r] for r in regions]

    agg_buttons = [
        dict(
            label='Monthly',
            method='restyle',
            args=[
                {'x': monthly_xs, 'y': monthly_ys},
                list(range(0, R))  # apply to line traces
            ]
        ),
        dict(
            label='Quarterly',
            method='restyle',
            args=[
                {'x': quarterly_xs, 'y': quarterly_ys},
                list(range(0, R))
            ]
        )
    ]

    new_fig.update_layout(
        title_text='Sales Data Analysis',
        height=1050,
        barmode='group',
        showlegend=True,
        updatemenus=[
            dict(
                buttons=region_buttons,
                x=1.0,
                y=1.15,
                xanchor='right',
                yanchor='top',
                direction='down',
                showactive=True,
                pad={'r': 10, 't': 10},
                bgcolor='white'
            ),
            dict(
                buttons=agg_buttons,
                x=1.1,
                y=1.15,
                xanchor='right',
                yanchor='top',
                direction='down',
                showactive=True,
                pad={'r': 10, 't': 10},
                bgcolor='white'
            )
        ]
    )

    new_fig.show()

# override previous do_plot by defining this enhanced version

if __name__ == '__main__':
    do_plot_v2()

