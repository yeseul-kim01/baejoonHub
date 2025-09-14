import sys
from collections import deque
input = sys.stdin.readline
move = [(0,1),(1,0)] # 이동 선택 list 

def bfs():
    d = deque([(0,0)])
    v[0][0] = True
    while d:
        cx,cy = d.popleft()
        if cx==N-1 and cy==M-1:
            return "Yes"
        else:
            for dx,dy in move:
                nx =cx +dx
                ny = cy+dy
                if nx <N and ny <M and not v[ny][nx] and gr[ny][nx]==1:
                    d.append((nx,ny))
                    v[ny][nx] =True
    return "No"


N,M = map(int,input().split( )) # N 은 가로 , M 은 세로
gr = [ list(map(int,input().split( ))) for _ in range(M)]
v = [[False]*N for _ in range (M)]

print(bfs())

