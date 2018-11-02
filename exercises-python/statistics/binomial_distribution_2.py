percentage, size = tuple(map(float, input().split()))

p = percentage / 100


def factorial(n):
    return 1 if n == 0 else n * factorial(n-1)


def combinations(n, x):
    return factorial(n) / factorial(x) / factorial(n-x)


def binomial(x, n, p):
    return combinations(n, x) * (p**x) * ((1-p)**(n-x))


print(round(binomial(0, size, p) + binomial(1, size, p) + binomial(2, size, p), 3))
print(round(1 - binomial(0, size, p) - binomial(1, size, p), 3))
