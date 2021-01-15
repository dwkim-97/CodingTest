def solution(s):
    array = s.split(" ")
    min = array[0]
    max = array[0]
    for i in array:
        if int(i) < int(min):
            min = i
        if int(i) > int(max):
            max = i

    return min + " " + max