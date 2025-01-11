from collections import deque
import sys
n,m = map(int,input().split())
inp=sys.stdin.readline
graph = [list(map(int, inp().split())) for _ in range(n)]    

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs(graph,a,b):
    tree = deque()
    tree.append((a,b))
    graph[a][b] = 0
    cnt = 1
    
    while tree:
        x,y = tree.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                tree.append((nx,ny))
                cnt +=1
    return cnt
    
show = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            show.append(bfs(graph,i,j))

print( l:= len(show))
if l != 0:
    print(max(show))
else:
    print(0)
