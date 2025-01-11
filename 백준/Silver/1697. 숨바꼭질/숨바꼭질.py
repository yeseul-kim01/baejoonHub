from collections import deque


N, K = map(int, input().split())

max_xy = 100000
visit = [0]*(max_xy+1)
def bfs():
    que = deque()
    que.append(N)
    
    while que:
        x = que.popleft()
        if x == K:
            print(visit[x])
            break
        for i in (x-1,x+1,x*2):
            if 0 <=i<=max_xy and not visit[i]:
                visit[i] = visit[x] + 1
                que.append(i)
    
    
bfs()