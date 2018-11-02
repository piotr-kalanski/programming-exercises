r1, r2 = tuple(map(float, input().split()))

p1 = r1 / (r1+r2)
p2 = 1 - p1


def factorial(n):
    return 1 if n == 0 else n * factorial(n-1)


def combinations(n, x):
    return factorial(n) / factorial(x) / factorial(n-x)


def binomial(x, n, p):
    return combinations(n, x) * (p**x) * ((1-p)**(n-x))


print(round(binomial(3, 6, p1) + binomial(4, 6, p1) + binomial(5, 6, p1) + binomial(6, 6, p1), 3))
