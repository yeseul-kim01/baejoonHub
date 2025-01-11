from collections import deque

input = __import__('sys').stdin.readline
arr = []
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
fire = deque()
n, m = map(int, input().split())
for i in range(n):
    arr.append(list(input().strip()))
    for j in range(m):
        if arr[i][j] == 'J':
            arr[i][j] = '.'
            start = (i, j)
        elif arr[i][j] == 'F':
            fire.append((i, j))

def solve():
    i, j = start
    visit = [[0] * m for _ in range(n)]
    q = deque()
    q.append((i, j))
    visit[i][j] = 1
    ans = 0
    while q:
        for _ in range(len(q)):
            i, j = q.popleft()
            for k in range(4):
                x, y = i + dx[k], j + dy[k]
                
                if not(0 <= x < n and 0 <= y < m):
                    return ans + 1
                if arr[x][y] == '.' and visit[x][y] == 0:
                    
                    flag = 1
                    for k in range(4):
                        cx, cy = x + dx[k], y + dy[k]
                        if not(0 <= cx < n and 0 <= cy < m): continue
                        if arr[cx][cy] == 'F': flag = 0
                        
                    if flag:
                        visit[x][y] = 1
                        q.append((x, y))
        
        for _ in range(len(fire)):
            i, j = fire.popleft()
            for k in range(4):
                x, y = i + dx[k], j + dy[k]
                if not(0 <= x < n and 0 <= y < m): continue
                if arr[x][y] == '.':
                    fire.append((x, y))
                    arr[x][y] = 'F'
            
        ans += 1
    return "IMPOSSIBLE"

print(solve())
