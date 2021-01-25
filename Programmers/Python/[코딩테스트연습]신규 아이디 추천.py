def solution(new_id):
    answer = []
    new_id = new_id.lower()

    for i in new_id:
        if i.isalnum() or i == '-' or i == '.' or i == '_':
            answer.append(i)

    print(answer)
    try:
        while True:
            check = False
            if answer[0] == '.':
                check = True
                answer = answer[1:]
            if answer[-1] == '.':
                check = True
                answer = answer[:-1]
            for i in range(len(answer) - 1):
                if answer[i] == '.' and answer[i + 1] == '.':
                    check = True
                    answer = answer[:i] + answer[i + 1:]
                    break
            if not check:
                break
    except:
        pass

    if len(answer) == 0:
        answer = 'a'
    if len(answer) > 15:
        answer = answer[:15]
        if answer[-1] == '.':
            answer = answer[:-1]
    if len(answer) < 3:
        answer += answer[-1] * (3 - len(answer))


    return ''.join(answer)


print(solution("...!@BaT#*..y.abcdefghijklm"))
print(solution("z-+.^."))
print(solution("=.="))
print(solution("123_.def"))
print(solution("abcdefghijklmn.p"))
