i = 3;
while i > 0:
    print(f"{i} > 0")
    i = i - 1

for item in [1, 2, 3, 4, 5]:
    print(item)

for item in range(10):
    print(item)
print("---------------")
for item in range(5, 10):
    print(item)
print("*******************")
for item in range(5, 10, 2):
    print(item)
print("------------------")

prices = [10, 20, 30]
total = 0
for price in prices:
    total += price
print(f"Total: {total}")
print("------------------")

numbers = [5, 2, 5, 2, 2]
for item in numbers:
    print("x" * item)
print("------------------")

for item in numbers:
    content = ''
    for count in range(item):
        content += 'x'
    print(content)
print("----------------")
