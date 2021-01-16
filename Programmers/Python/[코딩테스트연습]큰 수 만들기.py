def solution(number, k):
    checked = []
    i = 0

    while i < len(number) and k > 0:
        if len(checked) != 0 and int(checked[-1]) < int(number[i]):
            checked.pop(-1)
            k -= 1
        else:
            checked.append(number[i])
            i += 1

    answer = "".join(checked) + number[i:]
    if k != 0:
        answer = answer[:-k]

    return answer
