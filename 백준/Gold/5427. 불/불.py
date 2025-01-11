import sys
from collections import deque
import copy

input = sys.stdin.readline

T = int(input().rstrip())

def expand(matrix, fire):
    temp = []
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    w, h = len(matrix[0]), len(matrix)
    for x, y in fire:
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx and nx < h and 0 <= ny and ny < w:
                if matrix[nx][ny] == '.':
                    matrix[nx][ny] = '*'
                    temp.append([nx, ny])

    return temp

for _ in range(T):
    w, h = map(int, input().rstrip().split())
    matrix = [list(input().rstrip()) for _ in range(h)]
    visited = [[False] * w for _ in range(h)] 
    person_x, person_y = 0, 0
    fire = []
    for i in range(h):
        for j in range(w):
            if matrix[i][j] == '@':
                person_x, person_y = i, j
            if matrix[i][j] == '*':
                fire.append([i, j])

    queue = deque([[person_x, person_y, 0]])
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    visited[person_x][person_y] = True
    before = 0
    end = False
    while queue:
        x, y, step = queue.popleft()
        if before != step:
            fire = expand(matrix, fire)
            before = step

        if matrix[x][y] == '*':
            continue

        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx and nx < h and 0 <= ny and ny < w:
                if not visited[nx][ny] and matrix[nx][ny] == '.':
                    visited[nx][ny] = True
                    queue.append([nx, ny, step+1])
            else:
                print(step+1)
                end = True
                break
        if end:
            break
    if not end:
        print("IMPOSSIBLE")