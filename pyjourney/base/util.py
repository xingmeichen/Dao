def read_file(file_path):
    """
    Read a file and print the content
    param: file path
    """
    with open(file_path, 'r') as file:
        for line in file:
            print(line.strip())


if __name__ == "__main__":
    print("Hello World")
    read_file("./log/a.txt")

