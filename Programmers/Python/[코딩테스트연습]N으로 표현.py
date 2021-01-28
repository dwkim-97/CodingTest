def solution(N, number):
    dp = [[]]
    for i in range(1, 9):
        temp = []
        for j in range(1, i):
            for k in dp[j]:
                for l in dp[i - j]:
                    temp.append(k + l)
                    if k - l >= 0:
                        temp.append(k - l)
                    temp.append(k * l)
                    if l != 0 and k != 0:
                        temp.append(k // l)
        temp.append(int(str(N) * i))
        if number in temp:
            return i
        dp.append(list(set(temp)))

    return -1


print('1', solution(5, 12), 4)
print('2',solution(2,11),3)
print(solution(5,5),1)
print('3',solution(5,5125),-1)
print('4',solution(5,12),4)
print('5',solution(2,11),3)
print('6',solution(5,5),1)
print('7',solution(5,10),2)
print('8',solution(5,31168),-1)
print('9',solution(1,1121),7)
print('10',solution(5,1010),7)
print('11',solution(3,4),3)
print('12',solution(5,5555),4)
print('13',solution(5,5550),5)
print('14',solution(5,20),3)
print('15',solution(5,30),3)
print('16', solution(6, 65), 4)
print('17',solution(5,2),3)
print('18', solution(5, 4), 3)
print('19',solution(1,1),1)
print('20',solution(1,11),2)
print('21',solution(1,111),3)
print('22',solution(1,1111),4)
print('23',solution(1,11111),5)
print('24', solution(7, 7776), 6)
print('25',solution(7,7784),5)
print('26',solution(2,22222),5)
print('27',solution(2,22223),7)
print('28',solution(2,22224),6)
print('29',solution(2,11111),6)
print('30',solution(2,11),3)
print('31',solution(2,111),4)
print('32',solution(2,1111),5)
print('33',solution(9,36),4)
print('34',solution(9,37),6)
print('35',solution(9,72),3)
print('36',solution(3,18),3)
print('37',solution(2,1),2)
print('38',solution(4,17),4)
