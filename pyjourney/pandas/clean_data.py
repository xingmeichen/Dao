import pandas as pd

def dropna_demo():
    df = pd.read_json("./data/data.json")

    print(df.info())

    # dropna 会删除那些带有空值的行，
    # 默认情况下最终会返回一个新的 DataFrame, 而不会修改原来的 DataFrame
    # 如果想要修改原来的 DataFrame， 可以将参数 inplace 设置为True, 但是这个时候返回值就不是 DataFrame 了
    new_df = df.dropna()
    print(new_df.info())


def fillna_demo():
    df = pd.read_json("./data/data.json")

    print(df.info())

    # fillna 可以把空值替换成指定的值，默认情况下返回一个新的 DataFrame, 
    new_df = df.fillna(110)
    print(new_df.info())
    print(df.info())

    # 如果传入参数 inplace=True, 则会修改原来的 DataFrame, 且函数不返回一个 DataFrame
    df.fillna(112, inplace=True)
    print(df.info())


def fillna_demo2():
    df = pd.read_json("./data/data.json")
    print(df.info())

    # 值替换指定的列
    df.fillna({"Calories": 130}, inplace=True)
    print(df.info())


def mode_demo():
    """
    Docstring for mode_demo
    Mode = the value that appears most frequently.
    """
    df = pd.read_json("./data/data.json")

    the_mode = df["Calories"].mode()
    print(the_mode)
    print(type(the_mode))
    print(the_mode[0])


if __name__ == '__main__':
    # dropna_demo()

    # fillna_demo()

    mode_demo()

