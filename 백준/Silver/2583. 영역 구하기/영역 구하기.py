from collections import deque

m,n,k = map(int,input().split()) 
maps = [[1] * m for _ in range(n)]

for _ in range(k):
    x1, y1, x2, y2 = map(int,input().split())
    for i in range(x1,x2):
        for j in range(y1, y2):
            maps[i][j] = 0


result = []
q = deque()

for x in range(n):
    for y in range(m):
        if maps[x][y] == 1:
            ans = 0
            q.append((x,y))
            maps[x][y] = 0

            while q:
                x_,y_ = q.popleft()
                ans += 1

                dx = [0,0,1,-1]
                dy = [1,-1,0,0]

                for l in range(4):
                    nx = x_ + dx[l]
                    ny = y_ + dy[l]

                    if 0 <= nx < n and 0 <= ny < m:
                        if maps[nx][ny] == 1:
                            maps[nx][ny] = 0
                            q.append((nx,ny))
            result.append(ans)
print(len(result))
result.sort() 
print(*result)