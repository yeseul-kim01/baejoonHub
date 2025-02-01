import sys

input = sys.stdin.readline


def diffuse():
    directions = [(1, 0), (-1, 0), (0, -1), (0, 1)]

    amount = [[board[i][j] // 5 for j in range(C)] for i in range(R)]
    updated = [[0] * C for _ in range(R)]

    filter = []
    for i in range(R):
        for j in range(C):
            if board[i][j] == -1:
                filter.append(i)
                updated[i][j] = -1
                continue

            count = 4
            added = 0
            for d in directions:
                x, y = i + d[0], j + d[1]

                if x < 0 or x >= R or y < 0 or y >= C or board[x][y] == -1:
                    count -= 1
                else:
                    added += amount[x][y]

            updated[i][j] = board[i][j] - (amount[i][j] * count) + added

    return filter[0], filter[1], updated


def activate(filter_x, filter_y):
    # 시계 방향 순환
    for r in range(filter_x - 1, 0, -1):
        board[r][0] = board[r - 1][0]
    for c in range(C - 1):
        board[0][c] = board[0][c + 1]
    for r in range(filter_x):
        board[r][-1] = board[r + 1][-1]
    for c in range(C - 1, 0, -1):
        board[filter_x][c] = board[filter_x][c - 1]
    board[filter_x][1] = 0

    # 반시계 방향 순환
    for r in range(filter_y + 1, R - 1):
        board[r][0] = board[r + 1][0]
    for c in range(C - 1):
        board[-1][c] = board[-1][c + 1]
    for r in range(R - 1, filter_y, - 1):
        board[r][-1] = board[r - 1][-1]
    for c in range(C - 1, 0, -1):
        board[filter_y][c] = board[filter_y][c - 1]
    board[filter_y][1] = 0


def sum_dust():
    result = 0
    for row in board:
        result += sum(row)
    return result + 2 


R, C, T = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(R)]

for _ in range(T):
    x, y, board = diffuse()
    activate(x, y)

print(sum_dust())