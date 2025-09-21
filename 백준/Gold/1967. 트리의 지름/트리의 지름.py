##DFS 문제 

## 1967 문제 정리
# 무방향 그래프 , 노드 사이에 경로는 항상 한개 
import sys
from collections import deque

MIN = -1 ##최솟값
sys.setrecursionlimit(1000000)
input=sys.stdin.readline
def DFS(x,y): ##x시작 노드, y는 현재노드
    global s,s_x
    state = False
    try:
        for i,j in dic[y]:
                if max_dis[i]==-1:
                    state = True
                    max_dis[i]=j+max_dis[y]
                    DFS(x,i)
                if state == False:
                    if s<(r:=max_dis[y]):
                        s=r
                        s_x=y
    except: return 0,0
    return s,s_x
dic = {} ## 값저장, a:(b,c) - a가 부모노드,b가 자식노드,c가 길이
n = int(input())
for _ in range(n - 1):
    a, b, c = map(int, input().split())
    dic.setdefault(a, []).append((b, c))
    dic.setdefault(b,[]).append((a,c))
s = 0
s_x = 0
max_dis = [MIN]*(n+1) ## 최댓값 저장, 각 노드별 최댓값나온거
max_dis[1] = 0 ## 0으로 변환
result,node=DFS(1,1)
s = 0
s_x = 0
max_dis = [MIN]*(n+1) ## 최댓값 저장, 각 노드별 최댓값나온거
max_dis[node]=0
result2,node=DFS(node,node)
print(result2)
