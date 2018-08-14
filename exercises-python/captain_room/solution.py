from collections import Counter


def read_input():
    k = (int)(input())

    line = input().split(" ")
    room_numbers = list(map(int, line[0:(k*(k+1)+1)]))

    return k, room_numbers


def solve(k: int, room_numbers: list):
    counter = Counter()
    for r in room_numbers:
        counter[r] += 1

    for key in counter:
        if counter[key] == 1:
            result = key

    return result


if __name__ == '__main__':
    k, room_numbers = read_input()
    output = solve(k, room_numbers)
    print(output)
