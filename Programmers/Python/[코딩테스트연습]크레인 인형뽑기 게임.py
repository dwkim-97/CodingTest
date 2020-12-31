def solution(board, moves):
    answer = 0
    stack = [-1]
    size = len(board)
    for m in moves:
        popped = 0
        for i in range(size):
            if board[i][m-1] != 0:
                popped = board[i][m-1]
                board[i][m-1] = 0
                break
        if popped != 0:
            if stack[-1] == popped:
                stack.pop()
                answer += 2
            else:
                stack.append(popped)
    return answer