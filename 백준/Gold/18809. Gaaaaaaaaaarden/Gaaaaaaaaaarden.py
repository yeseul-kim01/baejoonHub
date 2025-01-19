import sys
input = sys.stdin.readline
from itertools import combinations
from collections import deque
dy = [1,-1,0,0]
dx = [0,0,1,-1]

def BFS():
  flower = 0
  while dq:
    y,x,ylast,xlast,time,color = dq.popleft()
    if visited[ylast][xlast] == 1: 
      continue
    if visited[y][x]:
      if visited[y][x] == (time,-color):
        visited[y][x] = 1
        flower += 1
      continue
    visited[y][x] = (time,color)
    for i in range(4):
      y1,x1 = y+dy[i],x+dx[i]
      if N>y1>=0 and M>x1>=0 and garden[y1][x1]:
        dq.append((y1,x1,y,x,time+1,color))
  return flower
    

N,M,G,R = map(int,input().split())

garden = []
for i in range(N):
  garden.append([*map(int,input().split())])

spread = []
for i in range(N):
  for j in range(M):
    if garden[i][j] == 2:
      spread.append((i,j))

result = 0
for GRlist in combinations(spread,G+R):
  for Glist in combinations(GRlist,G):
    visited = [[0]*M for i in range(N)]
    dq = deque()
    for y,x in Glist:
      visited[y][x] = 1
      dq.append((y,x,y,x,1,1)) 
    for y,x in GRlist:
      if visited[y][x]:
        continue
      dq.append((y,x,y,x,1,-1))
    visited = [[0]*M for i in range(N)]
    result = max(result,BFS())

print(result)