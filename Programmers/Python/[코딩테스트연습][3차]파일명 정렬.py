def solution(files):
    answer = []
    for f in files:
        head, number, tail = '', '', ''

        number_check = False
        for i in range(len(f)):
            if f[i].isdigit():
                number += f[i]
                number_check = True
            elif not number_check:
                head += f[i]
            else:
                tail = f[i:]
                break
        answer.append((head, number, tail))

    answer.sort(key=lambda x: (x[0].upper(), int(x[1])))

    return [''.join(t) for t in answer]

print(solution(['img12.png', 'img10.png', 'img02.png', 'img1.png', 'IMG01.GIF', 'img2.JPG']))
print(solution(['F-5 Freedom Fighter', 'B-50 Superfortress', 'A-10 Thunderbolt II', 'F-14 Tomcat']))