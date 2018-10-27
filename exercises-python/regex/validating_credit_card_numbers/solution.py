import re


def not_have_4_or_more_consecutive_repeated_digits(credit_card_number):
    counter = 0
    last_character = None
    for c in credit_card_number:
        if c == last_character:
            counter += 1
            if counter == 4:
                return False
        elif c != '-':
            counter = 1
            last_character = c
    return True


def is_valid(credit_card_number):
    return (re.match("^[4-6]\d{15}$", credit_card_number) or re.match("^[4-6]\d{3}-\d{4}-\d{4}-\d{4}$", credit_card_number)) and not_have_4_or_more_consecutive_repeated_digits(credit_card_number)


n = int(input())
credit_card_numbers = [input() for _ in range(n)]
for credit_card_number in credit_card_numbers:
    if is_valid(credit_card_number):
        print("Valid")
    else:
        print("Invalid")

print(credit_card_numbers)
