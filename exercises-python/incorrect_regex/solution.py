import re


def read_input():
    n = int(input())
    return [input() for _ in range(n)]


def is_correct_regex(regex_pattern: str):
    try:
        re.compile(regex_pattern)
        is_valid = True
    except re.error:
        is_valid = False
    return is_valid


def solve(regex_patterns: list):
    return list(map(is_correct_regex, regex_patterns))


if __name__ == '__main__':
    regex_patterns = read_input()
    output = solve(regex_patterns)
    for o in output:
        print(o)
