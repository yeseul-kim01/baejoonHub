from collections import deque
from copy import deepcopy
import sys

input = sys.stdin.readline
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def dfs(cnt):
    global min_ans
    if cnt == k:
        q2 = deepcopy(q)
        min_ans = min(min_ans, rotate(q2))
        return
    for i in range(k):
        if select[i]:
            continue
        select[i] = 1
        q.append(f[i])
        dfs(cnt+1)
        select[i] = 0
        q.pop()


def rotate(q):
    a2 = deepcopy(a)
    while q:
        x, y, z = q.popleft()
        lx, ly, rx, ry = x-z, y-z, x+z, y+z
        while True:
            if lx >= rx or ly >= ry:
                break
            dir = 0
            x, y, before = lx, ly, a2[lx][ly]
            while True:
                nx = x + dx[dir]
                ny = y + dy[dir]
                if not lx <= nx <= rx or not ly <= ny <= ry:
                    dir += 1
                    continue
                temp = a2[nx][ny]
                a2[nx][ny] = before
                before = temp
                x, y = nx, ny
                if [x, y] == [lx, ly]:
                    lx += 1; ly += 1; rx -= 1; ry -= 1
                    break

    ans = sys.maxsize
    for row in a2:
        ans = min(ans, sum(row))
    return ans


n, m, k = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

f = []
for _ in range(k):
    r, c, s = map(int, input().split())
    f.append([r-1, c-1, s])

select = [0 for _ in range(k)]
q = deque()
min_ans = sys.maxsize
dfs(0)
print(min_ans)