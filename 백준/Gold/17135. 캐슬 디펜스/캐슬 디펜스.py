def hunt(archor):
    boards = deepcopy(board) 
    visited = [[0] * M for _ in range(N)] 
    cnt = 0
    for i in range(N-1, -1, -1): 
        die = []
        for m in archor:
            queue = deque([[i, m, 1]])
            while queue:
                y, x, d = queue.popleft()
                if boards[y][x] :
                    die.append([y, x])
                    if not visited[y][x]:
                        visited[y][x] = 1
                        cnt += 1
                    break

                if d < D: 
                    for dx, dy in move:
                        nx, ny = x + dx, y + dy
                        if 0 <= ny < N and 0 <= nx < M:
                            queue.append([ny, nx, d+1]) 

        for y, x in die:
            boards[y][x] = 0

    return cnt

import sys
from copy import deepcopy
from collections import deque
from itertools import combinations
N, M, D = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)] 
move = [[-1,0],[0,-1],[1,0]]
result = 0
for archor in combinations([i for i in range(M)], 3): 
    result = max(result, hunt(archor))
print(result)