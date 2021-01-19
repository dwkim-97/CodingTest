def solution(cacheSize, cities):
    answer = 0
    i = 0
    cache = []
    if cacheSize == 0:
        return len(cities)*5
    for c in cities:
        city = c.upper()
        if city in cache:
            cache.remove(city)
            cache.append(city)
            answer += 1
        else:
            answer += 5
            if i < cacheSize:
                cache.append(city)
                i += 1
            else:
                cache.pop(0)
                cache.append(city)

    return answer

print(solution(3,['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA']))
#print(solution(3,['Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo', 'Seoul']))
#print(solution(2,['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'SanFrancisco', 'Seoul', 'Rome', 'Paris', 'Jeju', 'NewYork', 'Rome']))
#print(solution(5,['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'SanFrancisco', 'Seoul', 'Rome', 'Paris', 'Jeju', 'NewYork', 'Rome']))
#print(solution(2,['Jeju', 'Pangyo', 'NewYork', 'newyork']))
#print(solution(0,['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA']))
print(solution(5,[ "SEOUL", "SEOUL", "SEOUL" ]))
