

def read_input():
    len_a = (int)(input())
    set_a = set((input().split(" "))[0: len_a])
    n = (int)(input())
    operations = [(input().split(" ")[0], set(input().split(" "))) for _ in range(n)]
    return set_a, operations


def solve(set_a: set, operations):
    for op, other_set in operations:
        if op == "intersection_update":
            set_a.intersection_update(other_set)
        elif op == "update":
            set_a.update(other_set)
        elif op == "symmetric_difference_update":
            set_a.symmetric_difference_update(other_set)
        elif op == "difference_update":
            set_a.difference_update(other_set)

    return sum(map(int, set_a))


if __name__ == '__main__':
    set_a, operations = read_input()
    output = solve(set_a, operations)
    print(output)
