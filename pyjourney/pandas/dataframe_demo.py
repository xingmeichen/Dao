import pandas as pd


def dataframe_demo():
    data = {
        "calories": [420, 380, 390],
        "duration": [50, 40, 45]
    }

    df = pd.DataFrame(data)  # DataFrame 就像一个表格，dict 格式的data 的一个key 对应一列，
    print(df)

    # DataFrames 可以通过loc 获取指定的行
    print(df.loc[0])  # 返回第一行的值

    # 返回第一行和第二行的值, 返回类型跟只访问一行的时候不一样，这个时候返回类型是一个DataFrame
    print(df.loc[[0, 1]])

    # 可以通过index自己定义行名，没有定义的话就是默认的从0开始的序列
    df2 = pd.DataFrame(data, index=["day1", "day2", "day3"])
    print(df2)
    # 自定义行名之后就可以通过自定义的行名来访问指定的行
    print(df2.loc["day2"])


def access_by_column_name():
    data = {
        "calories": [420, 380, 390],
        "duration": [50, 40, 45]
    }

    df = pd.DataFrame(data)
    print(df['calories'])


def load_data_from_csv_file():
    df = pd.read_csv('./data/data.csv')

    # 当 DataFrame 的列数量超过 options.display.max_rows
    # 这样直接打印输出的不是完整的df, 而是省略的, 只有前面5行和最后5行
    print(df)
    print(pd.options.display.max_rows)  # 默认是60

    # 这样就能打印出完整的 df 了
    print(df.to_string())

    return df


def load_data_from_json_file():
    df = pd.read_json("./data/data.json")
    print(df)

    return df


def load_data_from_dict():
    data = {
        "user_id": {
            "0": 1,
            "1": 2, 
            "2": 3,
            "3": 4
        },
        "user_name": {
            "0": "Test1",
            "1": "Test2", 
            "2": "Test3",
            "3": "Test4"
        }
    }

    df = pd.DataFrame(data)
    print(df)

    print(df.head(2))

    print(df.tail(2))


if __name__ == "__main__":
    # df = load_data_from_csv_file()
    # print(df.info())

    access_by_column_name()

