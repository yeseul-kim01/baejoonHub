from collections import deque

def BFS(lst, p, num):
    global left
    res = []
    q = deque(lst)

    for j in range(num):
        if not left or len(q) == 0: return res
        for _ in range(len(q)):
            y, x = q.popleft()
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < N and 0 <= nx < M and field[ny][nx] == '.':
                    field[ny][nx] = p + 1
                    castles[p] += 1
                    left -= 1
                    q.append((ny, nx))
                    if j == num - 1:
                        res.append((ny, nx))

    return res

def BFS_blank(y, x):
    global left
    q = deque([(y, x)])
    visited[y][x] = 1
    while q:
        y, x = q.popleft()
        left += 1
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] \
            and field[ny][nx] == '.':
                visited[ny][nx] = 1
                q.append((ny, nx))

    left -= 1


N, M, P = map(int, input().split())
steps = list(map(int, input().split()))
field = [list(input()) for i in range(N)]
castles = [0 for i in range(P)]
left = 0
coors = [[] for i in range(P)]
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
visited = [[0 for i in range(M)] for j in range(N)]

for i in range(N):
    for j in range(M):
        if field[i][j] == '.' or field[i][j] == '#': continue
        else:
            field[i][j] = int(field[i][j])
            BFS_blank(i, j)
            castles[field[i][j]-1] += 1
            coors[field[i][j]-1].append((i, j))

while left:
    for i in range(P):
        coors[i] = BFS(coors[i], i, steps[i])

print(*castles)