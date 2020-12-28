def solution(n, lost, reserve):
    answer = n
    students = [0 for x in range(n)]
    for i in range(len(students)) : 
        if i+1 in lost :
            students[i] -= 1
        if i+1 in reserve :
            students[i] += 1
    print(students)
    for i in range(len(students)) :
        if students[i] < 0 :
            answer -= 1
    for j in range(len(students)) : 
        if students[j] < 0 :
            if j == 0 :
                if students[j+1] > 0 :
                    answer += 1
                    students[j+1] -= 1
                    students[j] += 1 
            if j > 0 and j < len(students)-1 :
                if students[j-1] > 0 :
                    answer += 1
                    students[j-1] -= 1
                    students[j] += 1
                elif students[j+1] > 0 :
                    answer += 1
                    students[j+1] -= 1
                    students[j] += 1 
            if j == len(students)-1 :
                if students[j-1] > 0 :
                    answer += 1
                    students[j-1] -= 1
                    students[j] += 1
    return answer