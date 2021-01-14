def solution(dartResult):
    divided = []
    check_point = 0
    for i in range(1, len(dartResult)):
        if i == len(dartResult) - 1:
            divided.append(dartResult[check_point:])
        if dartResult[i].isdigit():
            if dartResult[i] == "0" and dartResult[i - 1] == "1":
                continue
            else:
                divided.append(dartResult[check_point:i])
                check_point = i

    total_point = []
    for d in divided:
        if "10" in d:
            point = 10
        else:
            point = int(d[0])
        if "S" in d:
            total_point.append(point)
        elif "D" in d:
            total_point.append(point**2)
        elif "T" in d:
            total_point.append(point**3)
        if "#" in d:
            total_point[-1] *= -1
        elif "*" in d:
            for p in range(len(total_point)-2, len(total_point)):
                if p >= 0:
                    total_point[p] *= 2

    return sum(total_point)