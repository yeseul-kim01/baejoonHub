from collections import deque

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
island = {}
dist = 10000

def labeling_island():
    num = 0
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                num -= 1
                queue = deque([])
                queue.append([i, j])
                board[i][j] = num
                island[num] = []
                while queue:
                    r, c = queue.popleft()
                    check = False
                    for dr, dc in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        if 0<=r+dr<=n-1 and 0<=c+dc<=n-1:
                            if board[r+dr][c+dc] == 1:
                                board[r+dr][c+dc] = num
                                queue.append([r+dr, c+dc])
                            elif not board[r+dr][c+dc]:
                                check = True
                    if check:
                        island[num].append([r, c])

def calc_distance(i, j, num):
    global dist
    queue = deque([])
    queue.append([i, j])
    board_[i][j] = 0
    while queue:
        r, c = queue.popleft()
        for dr, dc in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
            if 0<=r+dr<=n-1 and 0<=c+dc<=n-1:
                if 0 == board_[r+dr][c+dc] or board_[r][c] + 1 < board_[r+dr][c+dc]:
                    queue.append([r+dr, c+dc])
                    board_[r+dr][c+dc] = board_[r][c] + 1

                elif board_[r+dr][c+dc] < 0 and board_[r+dr][c+dc] != num:
                    board_[i][j] = num
                    dist = min(board_[r][c], dist)
                    return 
    board_[i][j] = num

labeling_island()

for num, array in island.items():
    board_ = [x[:] for x in board]
    for i, j in array:
        calc_distance(i, j, num)

print(dist)