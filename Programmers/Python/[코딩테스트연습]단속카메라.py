def solution(routes):
    answer = 0
    all_t = []
    for r in range(len(routes)):
        all_t.append((routes[r][0], r, 's'))
        all_t.append((routes[r][1], r, 'e'))

    all_t.sort(key = lambda x:(x[0], -ord(x[2])))
    print(all_t)

    checked = []
    in_range = []
    for a in all_t:
        if len(checked) == len(routes):
            break
        if a[1] in checked:
            continue
        if a[-1] == 's':
            in_range.append(a[1])
        elif a[-1] == 'e' and len(in_range) != 0:
            checked += in_range
            in_range = []
            answer += 1

    return answer

print(solution([[-20,15], [15,17]]))