import math

n = input()
numbers = list(map(int, input().split()))
mean_value = sum(numbers) / len(numbers)
std_dev = math.sqrt(sum(((x-mean_value)**2 for x in numbers)) / len(numbers))
print(round(std_dev, 1))
