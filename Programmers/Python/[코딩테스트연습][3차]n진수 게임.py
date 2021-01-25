def solution(n, t, m, p):
    result = '0'
    over_ten = {'10': 'A', '11': 'B', '12': 'C', '13': 'D', '14': 'E', '15': 'F'}
    number = 0
    while len(result) < (t * m):
        temp_num = number
        changed_num = ''
        while temp_num != 0:
            print('n', number, temp_num, result)
            mod = str(temp_num % n)
            print('mod', mod)
            if mod in over_ten:
                changed_num += over_ten[mod]
            else:
                changed_num += mod
            temp_num = temp_num // n

        number += 1
        result += changed_num[::-1]
        print(result)

    answer = ''
    for i in range(len(result)):
        if len(answer) == t:
            break
        if i % m == p-1:
            answer += result[i]
    return answer


print(solution(2, 4, 2, 1))
#print('sol', solution(16, 16, 2, 1))
#print(solution(16, 16, 2, 2))
