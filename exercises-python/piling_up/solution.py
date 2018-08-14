

def read_input():
    n = int(input())
    return [p[1] for p in [(input(), list(map(int, input().split(' ')))) for _ in range(n)]]


def can_stack_cubes(cubes: list):
    can_stack = True
    current_top_cube = 2**31
    for i in range(len(cubes)):
        if cubes[0] >= cubes[-1] and cubes[0] <= current_top_cube:
            current_top_cube = cubes[0]
            cubes.pop()
        elif cubes[0] < cubes[-1] and cubes[-1] <= current_top_cube:
            current_top_cube = cubes[-1]
            cubes.pop(len(cubes)-1)
        else:
            can_stack = False
            break

    return can_stack


def solve(cubes_stacks: list):
    return list(map(can_stack_cubes, cubes_stacks))


if __name__ == '__main__':
    cubes_stacks = read_input()
    output = solve(cubes_stacks)
    for o in output:
        print("Yes" if o else "No")
