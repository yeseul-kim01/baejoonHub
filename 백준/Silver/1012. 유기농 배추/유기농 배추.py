from collections import deque
t = int(input())

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(visit, x, y):
    q = deque()
    q.append([x, y])
    visit[x][y] = 0
    
    while q: 
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<m and 0<=ny<n and visit[nx][ny] == 1:
                q.append([nx, ny])
                visit[nx][ny] = 0


for _ in range(t):  
    m, n, k = map(int, input().split())
    visit = [[0]*(n) for _ in range(m)] 
    for _ in range(k):
        a, b = map(int, input().split())
        visit[a][b] = 1
    cnt = 0
    for j in range(m):
        for k in range(n):
            if visit[j][k] == 1:
                bfs(visit, j, k)
                cnt+=1 
    print(cnt)