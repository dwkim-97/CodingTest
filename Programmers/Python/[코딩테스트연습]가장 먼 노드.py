def solution(n, edge):
    dic = {}
    visited = [True] + [False for i in range(1, n)]
    distance = [0 for i in range(n)]
    for e in edge:
        if (e[0] - 1) in dic:
            dic[e[0] - 1] += [e[1] - 1]
        else:
            dic[e[0] - 1] = [e[1] - 1]
        if (e[1] - 1) in dic:
            dic[e[1] - 1] += [e[0] - 1]
        else:
            dic[e[1] - 1] = [e[0] - 1]

    queue = [(0, 0)]
    while len(queue) != 0:
        dist, num = queue.pop(0)
        if distance[num] < dist:
            distance[num] = dist
        for i in dic[num]:
            if not visited[i]:
                queue += [(dist + 1, i)]
                visited[i] = True

    return distance.count(max(distance))