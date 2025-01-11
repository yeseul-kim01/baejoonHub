import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().strip().split())) for _ in range(N)]
visited = [[0]*N for _ in range(N)]

dx = [0,0,-1,1]
dy = [1,-1,0,0]
maxv = max(map(max, arr))
result = 0
temp = 0
rain = 0
q = deque()

def bfs(x,y):
    global rain
    q.appendleft([x,y])
    visited[x][y]=1
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<N and not visited[nx][ny]:
                if rain<arr[nx][ny]:
                    q.append([nx,ny])
                    visited[nx][ny]=1

while maxv>rain:
    for i in range(N):
        for j in range(N):
            if visited[i][j]==0 and rain<arr[i][j]:
                bfs(i,j)
                temp+=1
    visited = [[0]*N for _ in range(N)]
    result = max(temp,result)
    temp = 0
    rain+=1

print(result)