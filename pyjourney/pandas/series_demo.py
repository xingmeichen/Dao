import pandas as pd
 
if __name__ == '__main__':
    # pandas Series 就像一个表格中的一列
    a = range(4)
    var1  = pd.Series(a)
    print(var1)

    var2 = pd.Series(a, index = ["x", "y", "z", "m"])
    print(var2)

    b = [1, 2, "a", "b"]
    var3 = pd.Series(b, index = ["x", "y", "z", "m"])
    print(var3)
