from collections import deque

n = int(input())

grid = []
dxy = [(1, 0), (0, 1), (-1, 0), (0, -1)]
for _ in range(n):
    grid.append(input())

def bfs(dic):
    visited = [[False for _ in range(n)] for _ in range(n)]
    q = deque([])
    cnt = 0

    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                q.append((i, j, grid[i][j]))
                cnt += 1

                while q:
                    x, y, color = q.popleft()
                    visited[x][y] = True

                    for dx, dy in dxy:
                        if x+dx < 0 or x+dx >= n or y+dy < 0 or y+dy >= n:
                            continue
                        if dic[grid[x+dx][y+dy]] == dic[color] and not visited[x+dx][y+dy]:
                            q.append((x+dx, y+dy, grid[x+dx][y+dy]))
                            visited[x+dx][y+dy] = True
    return cnt

color_dic = {'R':0, 'G':1, 'B':2}
color_blind_dic = {'R':0, 'G':0, 'B':2}
print(bfs(color_dic), bfs(color_blind_dic))