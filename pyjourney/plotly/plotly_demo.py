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

if __name__ == '__main__':
    do_plot()

