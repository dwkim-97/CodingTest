def solution(n, s):
    if s < n:
        return [-1]
    else:
        if s % n == 0:
            return [s // n for i in range(n)]
        else:
            answer = [s // n for i in range(n)]
            mod = s % n
            index = 0
            while mod > 0:
                if index == n:
                    index = index % n
                answer[index] += 1
                mod -= 1
                index += 1
            return sorted(answer)