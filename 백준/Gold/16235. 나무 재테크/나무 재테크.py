import sys
from collections import deque
N, M, K = map(int, sys.stdin.readline().split())
eat = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
trees = [[[] for _ in range(N)] for i in range(N)]
for i in range(M):
    x,y,age = map(int, sys.stdin.readline().split())
    trees[x-1][y-1].append(age)
pan = [[5]*N for _ in range(N)]
die_trees = []
dx = [0,0,1,1,1,-1,-1,-1]
dy = [1,-1,0,-1,1,1,-1,0]

def spring():
    for i,line in enumerate(trees):
        for j, ages in enumerate(line):
            trees[i][j].sort()
            for k, age in enumerate(ages):
                if age<=pan[i][j]:
                    pan[i][j]-=age
                    trees[i][j][k]+=1
                else:
                    for _ in range(k,len(trees[i][j])):
                        die_trees.append([i,j,trees[i][j].pop()])
                    break
    
def summer(): 
    while die_trees:
        x,y,age = die_trees.pop()
        pan[x][y]+=age//2 
def autumn():
    for i,line in enumerate(trees):
        for j, ages in enumerate(line):
            for k, age in enumerate(ages):
                if age%5==0 and age!=0: 
                    for t in range(8):
                        ni=i+dx[t]
                        nj=j+dy[t]
                        if ni>=N or nj>=N or ni<0 or nj<0:
                            continue
                        trees[ni][nj].append(1)

            pan[i][j] += eat[i][j] 
for _ in range(K):
    spring()
    summer()
    autumn()
result = 0
for i in range(N):
    for j in range(N):
        result += len(trees[i][j])
print(result)