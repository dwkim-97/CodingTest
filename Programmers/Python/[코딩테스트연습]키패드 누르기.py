def solution(numbers, hand):
    answer = ''
    L_cur = 10
    R_cur = 12
    for n in numbers:
        print(L_cur, R_cur)
        if n == 1 or n == 4 or n == 7:
            answer += "L"
            L_cur = n
        elif n == 3 or n == 6 or n == 9:
            answer += "R"
            R_cur = n
        else:
            if n == 0:
                n = 11

            L_dis = abs(L_cur - n) // 3 + abs(L_cur - n) % 3
            R_dis = abs(R_cur - n) // 3 + abs(R_cur - n) % 3

            if L_dis > R_dis:
                answer += "R"
                R_cur = n
            elif R_dis > L_dis:
                answer += "L"
                L_cur = n
            else:
                if hand == "right":
                    answer += "R"
                    R_cur = n
                else:
                    answer += "L"
                    L_cur = n
    return answer