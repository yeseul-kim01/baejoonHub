import sys
from collections import deque

arr =[list(sys.stdin.readline().strip()) for _ in range(5)]
location = [(i,j) for i in range(5) for j in range(5)]
result = []
s = []
cnt = 0

def available(s):
    l = [i for i in s]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    q = deque([l[0]])
    l.remove(l[0])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (nx, ny) in l:
                q.append((nx, ny))
                l.remove((nx, ny))
    if len(l) == 0:
        return True
    return False

def back(x):
    global cnt
    if len(result) == 7 :
        # print(s)
        if s.count('S')>=4 and available(result):
            cnt +=1
        return
    for i in range(x,25):
        nx, ny = location[i]
        result.append((nx,ny))
        s.append(arr[nx][ny])
        back(i+1)
        result.pop()
        s.pop()
        
back(0)
print(cnt)