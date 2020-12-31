def solution(n):
    answer = ''

    while n >= 3:
        q, r = divmod(n, 3)
        if r == 0:
            answer += '4'
            q -= 1
        else:
            answer += str(r)
        n = q

    if n != 0:
        answer += str(n)

    return answer[::-1]