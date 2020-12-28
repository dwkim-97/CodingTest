def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()
    for i in range(len(participant)):
        if i == len(participant)-1 or participant[i] != completion[i] :
            answer = participant[i]
            break;
    return answer