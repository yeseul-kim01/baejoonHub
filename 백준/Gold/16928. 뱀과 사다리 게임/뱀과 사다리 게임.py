#백준 16928
import sys
from collections import deque


def bfs(jump):
    q=deque([1]) #현재 위치에 대한 정보, 주사위 굴린 후 들어가는 위치값 모두 저장 
    pr_x=[-1]*101 # 최소 주사위 굴린 횟수
    pr_x[1]=0 #현재 위치에서의 주사위 횟수 
    while q:
        x=q.popleft()
        if x==100:
            break
        for i in range(1,7):
            re_x=x+i
            if re_x >100: continue
            nx_x=jump.get(re_x,False)
            if nx_x:     
                if pr_x[nx_x] == -1:
                    q.append(nx_x)
                    pr_x[nx_x]= pr_x[x] +1
            else: 
                if pr_x[re_x] == -1:
                    q.append(re_x)
                    pr_x[re_x] = pr_x[x] +1
                
    return pr_x[100]
    
    
    
(a, b), *l = (list(map(int, line.strip("\n").split())) for line in open(0))
jump = {s: e for s, e in l} # 조회 좀 더 편하게 딕셔너리로 해야될듯


print(bfs(jump))
