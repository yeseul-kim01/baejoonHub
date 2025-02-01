from collections import deque
import copy

n, m, k = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
ball = [2, 4, 1, 3, 5, 6]
dir = 0 

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
x, y = 0, 0
result = 0 

def ball_move(x, y, dir) :
    nx = x + directions[dir][0]
    ny = y + directions[dir][1]
    if check(nx, ny) :
        nd = (dir + 2) % 4
        nx = x + directions[nd][0]
        ny = y + directions[nd][1]
        return [nx, ny, nd]
    return [nx, ny, dir]


def check(nx, ny) :
    if not (0 <= nx < n and 0 <= ny < m) :
        return True
    return False

def change_ball(ball, dir) :
    if dir == 0 :
        ball[1], ball[2], ball[3], ball[5] = ball[5], ball[1], ball[2], ball[3]
    elif dir == 1 :
        ball[0], ball[2], ball[4], ball[5] = ball[5], ball[0], ball[2], ball[4]
    elif dir == 2 :
        ball[1], ball[2], ball[3], ball[5] = ball[2], ball[3], ball[5], ball[1]
    elif dir == 3 :
        ball[0], ball[2], ball[4], ball[5] = ball[2], ball[4], ball[5], ball[0]

    return ball

def bfs(x, y) :
    cnt = 1
    visited = [[0] * m for _ in range(n)]
    q = deque()
    q.append([x, y])
    while q :
        r, c = q.popleft()
        visited[r][c] = 1
        for i in range(4) :
            nr = r + directions[i][0]
            nc = c + directions[i][1]
            if check(nr, nc) :
                continue
            if data[r][c] == data[nr][nc] and not visited[nr][nc] :
                visited[nr][nc] = 1
                q.append([nr, nc])
                cnt += 1

    return cnt

for _ in range(k) :
    x, y, dir = ball_move(x, y, dir)
    ball = change_ball(ball, dir)
    count = bfs(x, y)
    result += data[x][y] * count

    a, b = ball[5], data[x][y]
    if a > b :
        dir = (dir + 1) % 4
    elif a < b :
        dir = (dir - 1)
        if dir == -1 :
            dir = 3

print(result)