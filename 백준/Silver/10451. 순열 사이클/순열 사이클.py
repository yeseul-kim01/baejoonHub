import sys
from collections import deque

def bfs(x):
    q = deque([x]) #첫번째 자리 넣기_ 배열 위치 저장
    while q: #q 에 아무것도 없을 때 까지
        cu = q.popleft() #현재 위치 빼기_ 배열위치 저장
        visit[cu] =True
        nx = l[cu] #그 다음 위치
        if not visit[nx-1]:
                q.append(nx-1) # 그다음 위치값을 저장해야 함.

input = sys.stdin.readline
T = int(input())
for i in range (T):
    n=int(input())
    l=list(map(int,input().split(" ")))
    visit = [False]*n #방문 여부
    s=0
    for i in range(n):
        if not visit[i-1]: # 방문하지 않은 곳이면
            bfs(i-1)
            s +=1
    print(s)
