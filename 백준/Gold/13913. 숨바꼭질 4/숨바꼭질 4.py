import sys
from collections import deque
 
input = sys.stdin.readline
MAX = 100001
n, k = map(int,input().split())
dq = deque()
dist = [-1]*MAX
route = [-1]*MAX
 
def track(o,d):
    routes = []
    dest = k
    routes.append(k)
    while dest != o:
        routes.append(route[dest])
        dest = route[dest]
    routes.reverse()
    print(' '.join(map(str, routes)))

dist[n]=0
route[n]=n
dq.append(n)
while dq:
    x = dq.popleft()
    if x == k: 
        print(dist[k])
        track(n,k)
        break
    for nx in [x+1,x-1,2*x]:
        if 0<=nx<MAX and dist[nx]==-1:
            dist[nx]=dist[x]+1
            route[nx] = x
            dq.append(nx)