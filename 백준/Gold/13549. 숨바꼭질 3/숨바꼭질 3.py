# 직선에서 이동하는 것, 이동은 순간이동이랑 걷는 거 있음. 
# 움직이는 방식은 총 두개임
from collections import deque

def bfs():
    q = deque([n]) # 시작 위치
    visit_time[n] = 0 #시작위치에서 시간은 0
    while q:
        # print("q문 돌리기:",q)
        # print("시간:",visit_time[0:40])
        x = q.popleft() # 큐에서 뺀값
        if x == m:
            break
        for j,i  in enumerate ([x*2,x-1,x+1]):#우선순위대로 먼저시작
            if 0 <= i <= MAX and visit_time[i] == -1: # m 값 보다 작으면
                if j ==0:
                    q.appendleft(i)
                    visit_time[i] = visit_time[x]
                else: 
                    if i>=0:
                        q.append(i)
                        visit_time[i] = 1 + visit_time[x]
                # print(i,"업데이트 시간:",visit_time[i])
    return visit_time[m]


n,m=map(int,input().split( ))#n 시작위치,m 끝위치
MAX = 100000
visit_time = [-1]*100001
#시간 저장 -> -1이면 방문 아직 안한곳,최소시간 저장하면됨.
print(bfs())

    
 