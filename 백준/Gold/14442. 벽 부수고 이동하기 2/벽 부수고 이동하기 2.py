import sys
from collections import deque
read = sys.stdin.readline
dx = [-1,1,0,0]
dy = [0,0,-1,1]

N,M,K = map(int, read().split())
matrix = [ list(map(int,read().rstrip())) for _ in range(N) ]
visited = [ [ [0]*M for _ in range(N) ] for _ in range(K+1) ]

def bfs(break_cnt,x,y):
    q = deque()
    q.append([break_cnt, x, y])
    visited[break_cnt][x][y] = 1

    while q:
        cnt, x, y= q.popleft()

        if x == N-1 and y == M-1:
            return visited[cnt][x][y]

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if matrix[nx][ny] == 0 and visited[cnt][nx][ny] == 0:
                    visited[cnt][nx][ny] = visited[cnt][x][y] + 1
                    q.append([cnt,nx,ny])

                elif matrix[nx][ny] == 1 and cnt < K and visited[cnt + 1][nx][ny] == 0:
                    visited[cnt+1][nx][ny] = visited[cnt][x][y] + 1
                    q.append([cnt+1,nx,ny])

    return -1
    
print(bfs(0,0,0))