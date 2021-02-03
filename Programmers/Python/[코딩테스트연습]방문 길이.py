def solution(dirs):
    answer = 0
    history = {}
    for i in range(-5, 6):
        for j in range(-5, 6):
            history[(i, j)] = []

    x = 0
    y = 0
    for d in dirs:
        prev = (x, y)

        if d == 'L' and x != -5:
            prev_d = 'R'
            x -= 1
        elif d == 'R' and x != 5:
            prev_d = 'L'
            x += 1
        elif d == 'U' and y != 5:
            prev_d = 'D'
            y += 1
        elif d == 'D' and y != -5:
            prev_d = 'U'
            y -= 1
        else:
            continue

        if d not in history[(x, y)] and prev_d not in history[prev]:
            history[(x, y)].append(d)
            history[prev].append(prev_d)
            answer += 1

    return answer