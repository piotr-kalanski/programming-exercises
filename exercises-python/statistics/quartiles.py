n = input()
numbers = list(map(int, input().split()))


def median(collection):
    if len(collection) % 2 == 0:
        return (collection[len(collection)//2 - 1] + collection[len(collection)//2]) / 2
    else:
        return collection[len(collection)//2]


def quartiles(collection):
    numbers.sort()
    if len(numbers) % 2 == 0:
        lower_half = numbers[:len(numbers)//2]
        upper_half = numbers[len(numbers)//2:]
    else:
        lower_half = numbers[:len(numbers)//2]
        upper_half = numbers[len(numbers)//2+1:]

    return median(lower_half), median(collection), median(upper_half)


q1, q2, q3 = quartiles(numbers)

print(round(q1))
print(round(q2))
print(round(q3))
