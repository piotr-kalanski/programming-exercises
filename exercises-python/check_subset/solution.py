n = int(input())
set_pairs = [[set(input().split(' ')) for _ in range(4)] for _ in range(n)]

for _, a, _, b in set_pairs:
    print(len(a.difference(b)) == 0)
