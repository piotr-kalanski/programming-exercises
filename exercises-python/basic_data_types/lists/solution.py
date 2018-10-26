


def read_input():
    n = int(input())
    commands = [input() for _ in range(n)]

    return commands

def solve(commands):
    current_list = []
    result = []
    commands_parsed = [c.split(' ') for c in commands]
    for command in commands_parsed:
        cmd = command[0]
        if cmd == "insert":
            current_list.insert(int(command[1]), int(command[2]))
        elif cmd == "print":
            result.append(current_list.copy())
        elif cmd == "remove":
            current_list.remove(int(command[1]))
        elif cmd == "append":
            current_list.append(int(command[1]))
        elif cmd == "sort":
            current_list.sort()
        elif cmd == "pop":
            current_list.pop()
        elif cmd == "reverse":
            current_list.reverse()

    return result


if __name__ == '__main__':
    commands = read_input()
    output = solve(commands)
    for o in output:
        print(o)
