def solution(board):
    N = len(board)
    new_board = []
    for i in range(N):
        for j in range(N):
            new_board.append(board[i][j])

    visited = []
    queue = [(0, 0, 1)]
    while len(queue) != 0:

        cnt, fir, sec = queue.pop(0)
        if sec == N*N-1:
            return cnt
        if (fir, sec) in visited:
            continue
        visited.append((fir,sec))

        if sec - fir == 1:
            if sec % N != N - 1 and new_board[sec + 1] == 0:
                queue.append((cnt + 1, fir + 1, sec + 1))
            if sec % N != 1 and new_board[fir - 1] == 0:
                queue.append((cnt + 1, fir - 1, sec - 1))
            if sec + N < N * N and (new_board[fir + N], new_board[sec + N]) == (0, 0):
                queue.append((cnt + 1, fir + N, sec + N))
                queue.append((cnt + 1, fir, fir + N))
                queue.append((cnt + 1, sec, sec + N))
            if sec - N > 0 and (new_board[fir - N], new_board[sec - N]) == (0, 0):
                queue.append((cnt + 1, fir - N, sec - N))
                queue.append((cnt + 1, fir - N, fir))
                queue.append((cnt + 1, sec - N, sec))
        else:
            if sec % N != N - 1 and (new_board[fir + 1], new_board[sec + 1]) == (0, 0):
                queue.append((cnt + 1, fir + 1, sec + 1))
                queue.append((cnt + 1, fir, fir + 1))
                queue.append((cnt + 1, sec, sec + 1))
            if sec % N != 0 and (new_board[fir - 1], new_board[sec - 1]) == (0, 0):
                queue.append((cnt + 1, fir - 1, sec - 1))
                queue.append((cnt + 1, fir - 1, fir))
                queue.append((cnt + 1, sec - 1, sec))
            if sec + N < N * N and new_board[sec + N] == 0:
                queue.append((cnt + 1, fir + N, sec + N))
            if fir - N > 0 and new_board[fir - N] == 0:
                queue.append((cnt + 1, fir - N, sec - N))

#print(solution([[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]))
#print(solution([[0,0,0,0,0],[1,0,0,1,1],[0,0,0,1,1],[0,0,0,1,1],[0,0,0,0,0]]))
#print(solution([[0,0,0,0,0],[1,1,0,0,1],[0,0,0,1,1],[0,0,0,1,1],[0,0,0,0,0]]))
print(solution([[0, 0, 0, 0, 1, 0], [0, 0, 1, 1, 1, 0], [0, 1, 1, 1, 1, 0], [0, 1, 0, 0, 1, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 0, 0, 0]]))