def solution(msg):
    answer = []
    dictionary = [chr(a) for a in range(65, 91)]
    cnt = 0
    i = 0
    while i < len(msg):
        s = msg[i]
        for j in range(i+1, len(msg)+1):
            if msg[i:j] in dictionary:
                s = msg[i:j]
            else:
                break
        answer.append(dictionary.index(s)+1)
        dictionary.append(msg[i:j])
        cnt += len(s)
        if cnt == len(msg):
            return answer
        else:
            i = j-1

    return answer

#print(solution('TOBEORNOTTOBEORTOBEORNOT'))
print(solution('KAKAO'))
print(solution('KAKA'))
#print(solution('ABABABABABABABAB'))