def solution(maps):
    n, m = len(maps), len(maps[0])
    visited = [[False for i in range(m)] for j in range(n)]

    visited[0][0] = True
    queue = [(1, 0, 0)]
    while len(queue) != 0:
        count, i, j = queue.pop(0)
        if (i, j) == (n - 1, m - 1):
            return count

        if i + 1 < n and maps[i + 1][j] != 0 and not visited[i + 1][j]:
            visited[i + 1][j] = True
            queue.append((count + 1, i + 1, j))

        if i - 1 >= 0 and maps[i - 1][j] != 0 and not visited[i - 1][j]:
            visited[i - 1][j] = True
            queue.append((count + 1, i - 1, j))

        if j + 1 < m and maps[i][j + 1] != 0 and not visited[i][j + 1]:
            visited[i][j + 1] = True
            queue.append((count + 1, i, j + 1))

        if j - 1 >= 0 and maps[i][j - 1] != 0 and not visited[i][j - 1]:
            visited[i][j - 1] = True
            queue.append((count + 1, i, j - 1))

    return -1