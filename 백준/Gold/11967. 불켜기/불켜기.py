from sys import stdin
from collections import deque, defaultdict

input = stdin.readline


dr = (-1, 1, 0, 0)
dc = (0, 0, -1, 1)

def bfs():
    result = 1    
    visited = [[0] * N for _ in range(N)]  
    visited[0][0] = 1
    lights = [[0] * N for _ in range(N)]  
    lights[0][0] = 1
    Q = deque([(0, 0)])
    while Q:
        r, c = Q.popleft()
        for tr, tc in turnInfo[(r, c)]:   
            if not lights[tr][tc]:
                lights[tr][tc] = 1      
                result += 1
                for d in range(4):     
                    nr = tr + dr[d]
                    nc = tc + dc[d]
                    if not (0 <= nr < N and 0 <= nc < N):
                        continue
                    if visited[nr][nc]:   
                        Q.append((nr, nc))  
        for d in range(4):    
            nr = r + dr[d]
            nc = c + dc[d]
            if not (0 <= nr < N and 0 <= nc < N):
                continue
            if not visited[nr][nc] and lights[nr][nc]:
                Q.append((nr, nc))    
                visited[nr][nc] = 1     
                
    return result


N, M = map(int, input().split())
turnInfo = defaultdict(list)	
for _ in range(M):
    sr, sc, tr, tc = map(int, input().split())
    turnInfo[(sr-1, sc-1)].append((tr-1, tc-1))

print(bfs())