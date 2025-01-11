import sys
from collections import deque

n = int(sys.stdin.readline())
graph = []

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for _ in range(n):
	graph.append(list(map(int, input())))

def bfs(a, b):
    count = 0
    
    q = deque()
    q.append((a, b))


    graph[a][b] = 0

    while q:
        x, y = q.popleft()
        count += 1 
        
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            if 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] == 1:
                    graph[nx][ny] = 0
                    q.append((nx, ny))

    return count
                    
total = 0

nums_list = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            nums_list.append(bfs(i, j))
            total += 1 
            
print(total)
for x in sorted(nums_list):
	print(x)