names = ['Alice', 'Bob', "Carter", 'Davie']
print(names)
print(names[:])
print(names[0])
print(names[2:8])
print(names[2:3])
print(names[2:])
print("----------------")

numbers = [3, 6, 2, 8, 4, 10, 2, 7]
max = numbers[0]
for item in numbers:
    if max < item:
        max = item
print(max)
print("----------------")

matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print(matrix[0])
print(matrix[0][1])
matrix[0][1] = 10
print(matrix[0][1])
print("-----------------")

for row in matrix:
    for column in row:
        print(column)
print("------------------")

numbers = [4, 3, 6, 9, 8]
numbers.insert(4, 10)
print(numbers)
numbers.sort();
print(numbers)
numbers2 = numbers.copy()
print(numbers2)