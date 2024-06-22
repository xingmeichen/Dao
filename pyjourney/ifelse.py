is_hot = False
is_cold = False

if is_hot:
    print('It is a hot day')
    print('Drink plenty of water')
elif is_cold:
    print('It is a could day')
    print("Wear warm clothes")
else:
    print('It is a lovely day')
print('Enjoy your day')


has_high_income = True
has_good_credit = True
has_criminal_record = False
if has_high_income and has_good_credit:
    print("Eligible for load")
if has_high_income or has_good_credit:
    print("Eligible for load")
if has_good_credit and not has_criminal_record:
    print("Eligible for load")

temperature = 25
if temperature == 25:
    print("good")

name = "J"
if len(name) < 3:
    print("Name must be at least 3 characters")
elif len(name) >50:
    print("Name must be maximum 50 characters")
else:
    print("Name is good")