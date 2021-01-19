def solution(m, n, board):
    answer = 0

    for i in range(len(board)):
        popped = board.pop(0)
        board.append([p for p in popped])

    while True:
        checked = []
        for i in range(m - 1):
            for j in range(n - 1):
                if board[i][j] == "0":
                    continue
                if board[i][j] == board[i][j + 1]:
                    if board[i][j] == board[i + 1][j] and board[i][j + 1] == board[i + 1][j + 1]:
                        checked.append((i, j))
                        checked.append((i, j + 1))
                        checked.append((i + 1, j))
                        checked.append((i + 1, j + 1))

        if len(checked) == 0:
            break
        else:
            answer += len(set(checked))
            for c in checked:
                board[c[0]][c[1]] = '0'

            for c in reversed(checked):
                check_n = c[0] - 1
                put_n = c[0]

                while check_n >= 0:
                    if board[put_n][c[1]] == "0" and board[check_n][c[1]] != "0":
                        board[put_n][c[1]] = board[check_n][c[1]]
                        board[check_n][c[1]] = "0"
                        put_n -= 1

                    check_n -= 1

    return answer

print(solution(4,5,["CCBDE", "AAADE", "AAABF", "CCBBF"]))
print(solution(6,6,['AABBEE','AAAEEE','VAAEEV','AABBEE','AACCEE','VVCCEE']))
print(solution(6,6,['TTTANT', 'RRFACC', 'RRRFCC', 'TRRRAA', 'TTMMMF', 'TMMTTJ']))
print(solution(6, 6, ['IIIIOO', 'IIIOOO', 'IIIOOI', 'IOOIII', 'OOOIII', 'OOIIII']))
print(solution(5, 6, ['AAAAAA','BBAATB','BBAATB','JJJTAA','JJJTAA']))
print(solution(8,5,['HGNHU', 'CRSHV', 'UKHVL', 'MJHQB', 'GSHOT', 'MQMJJ', 'AGJKK', 'QULKK']))
