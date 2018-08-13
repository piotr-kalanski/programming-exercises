import sys


def read_input():
    count1 = (int)(input())
    english_line = input()
    count2 = (int)(input())
    french_line = input()
    english_students = set((english_line.split(" "))[0:count1])
    french_students = set((french_line.split(" "))[0:count2])

    return english_students, french_students


def solve(english_students, french_students):
    return len(english_students.difference(french_students))


if __name__ == '__main__':
    english_students, french_students = read_input()
    output = solve(english_students, french_students )
    print(output)
