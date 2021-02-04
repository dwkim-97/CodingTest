
from collections import Counter

def solution(a):
    answer = 0

    if len(a) <= 1:
        return 0

    counter = Counter(a).most_common()
    counter = {n: c for n, c in counter}

    for n in counter:
        if counter[n] * 2 <= answer:
            continue

        index = 1
        count = 0

        while index < len(a):
            if (a[index - 1] != n and a[index] != n) or a[index - 1] == a[index]:
                index += 1
                continue

            count += 2
            index += 2

        answer = max(answer, count)

    return answer

print('1:',solution([1,1,1,1,1,1,2,3,2,4]))
print('2:',solution([5, 2, 3, 3, 5, 3]))
print('3:',solution([0,3,3,0,7,2,0,2,2,0]))
print('4:',solution([1,3,1,3,1,3,1,3]))
print('5:',solution([1,5,4,4,1,3,1,3]))
print('6:',solution([4, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3]))
print('7:',solution([0, 0, 0, 2, 3, 4, 3, 5, 3, 1]))
print('8:',solution([1,3,3,5,3,3]))
print('9:',solution([3,3,3,4,3,4,3]))
print('10:',solution([1,2,0]))
print('11:',solution([1,2,1]))
print('12:',solution([2,2,1]))
print('13:',solution([1,2,2]))
print('14:',solution([2,2,2]))
print('15:',solution([1,2,1,3,4,1,1,3]))
print('16:',solution([1,3,3,1,1,3,3,1]))
print('17:',solution([1,3,3,1,3,3,1]))
print('18:',solution([2,2,1,1,2,2]))
print('19:',solution([3,3,3,3,3,3,3]))
print('20:',solution( [4, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3]))
print('21:',solution([0]))
print('22:',solution([1,1]))
print('23:',solution([1,0]))
print('24:',solution([0,1,2,3,4,5]))

# def solution(a):
#     answer = 0
#
#     if len(a) == 1:
#         return answer
#
#     stars = {i: [] for i in range(len(a))}
#
#     if a[1] != a[0]:
#         stars[a[1]].append(1)
#     if a[-2] != a[-1]:
#         stars[a[-2]].append(len(a)-2)
#
#     for i in range(1, len(a)-1):
#         if a[i-1] != a[i] and a[i+1] != a[i]:
#             if a[i-1] == a[i+1]:
#                 stars[a[i-1]].append(i-1)
#             else:
#                 stars[a[i-1]].append(i-1)
#                 stars[a[i+1]].append(i+1)
#         elif a[i-1] != a[i]:
#             stars[a[i-1]].append(i-1)
#         elif a[i+1] != a[i]:
#             stars[a[i+1]].append(i+1)
#
#     return max(len(set(v)) for v in stars.values()) * 2
#
