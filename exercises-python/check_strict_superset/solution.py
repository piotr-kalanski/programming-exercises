


def read_input():
    a = set(input().split(' '))
    n = int(input())
    other_sets = [set(input().split(' ')) for _ in range(n)]

    return a, other_sets


def is_superset(a, b):
    return (len(a.difference(b)) > 0) and (len(b.difference(a)) == 0)


def solve(a, other_sets):
    return len([1 for other_set in other_sets if not is_superset(a, other_set)]) == 0


if __name__ == '__main__':
    a, other_sets = read_input()
    output = solve(a, other_sets)
    print(output)
