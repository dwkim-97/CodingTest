def solution(people, limit):
    answer = 0
    lowest = 0
    highest = len(people) - 1

    people.sort()
    while lowest <= highest:
        if people[lowest] + people[highest] > limit:
            answer += 1
            highest -= 1
        else:
            answer += 1
            lowest += 1
            highest -= 1

    return answer