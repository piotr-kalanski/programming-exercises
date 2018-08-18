if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    max_element = max(arr)
    print(max([i for i in arr if i != max_element]))
