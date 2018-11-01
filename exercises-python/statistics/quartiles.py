n = input()
numbers = list(map(int, input().split()))
numbers.sort()

if len(numbers) % 2 == 0:
    lower_half = numbers[:len(numbers)//2]
    upper_half = numbers[len(numbers)//2:]
else:
    lower_half = numbers[:len(numbers)//2]
    upper_half = numbers[len(numbers)//2+1:]

def median(collection):
    if len(collection) % 2 == 0:
        return (collection[len(collection)//2 - 1] + collection[len(collection)//2]) / 2
    else:
        return collection[len(collection)//2]

print(round(median(lower_half)))
print(round(median(numbers)))
print(round(median(upper_half)))
