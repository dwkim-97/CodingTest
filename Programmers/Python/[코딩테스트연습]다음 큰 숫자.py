def solution(n):
    answer = 0
    binary = list(bin(n).replace("0b", "0"))
    print(binary)
    found = False
    one_cnt = 0
    for i in range(len(binary)-1, -1, -1):
        print(i)
        if binary[i] == "1":
            found = True
            binary[i] = "0"
            one_cnt += 1
            print("checked", i)
            print("b1", binary)
        elif found and binary[i] == "0":
            binary[i] = "1"
            one_cnt -= 1
            print("b2", binary)
            while one_cnt > 0:
                binary[-one_cnt] = "1"
                one_cnt -= 1
            print("b3", binary)
            break


    return int(''.join(binary),2)

print(solution(15))