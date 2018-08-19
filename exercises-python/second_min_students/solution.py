if __name__ == '__main__':
    current_min = 100000.0
    current_second_min = 1000000.0
    people_with_min = []
    people_with_second_min = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        if score == current_second_min:
            people_with_second_min.append(name)
        if score == current_min:
            people_with_min.append(name)
        elif score < current_min:
            current_second_min = current_min
            people_with_second_min = people_with_min.copy()
            current_min = score
            people_with_min = [name]
        elif score < current_second_min:
            current_second_min = score
            people_with_second_min = [name]

    for p in sorted(people_with_second_min):
        print(p)
