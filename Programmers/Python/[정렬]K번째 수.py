def solution(array, commands) :
    return list(sorted(array[l[0]-1:l[1]])[l[2]-1] for l in commands)