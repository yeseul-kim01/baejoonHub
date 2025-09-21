#다익스트라 구현
# 우선순위 큐로 구현 (순차 탐색 시 시간 복잡도가 크게 나올 수 있음.)
# 방문 여부 [visit table] 이 필요함
# 현재까지 합해진 거리의 최솟값 배열 [min_dis table] 이 필요함
# 우선 순위 큐 안에는 <노드,간선의 크기> -> 
# 이때 간선의 크기는 해당 간선을 지날 때 더해지는 거리값임.

##문제 간선 하나당 무조건 거리는 1
##도착지가 정해지지 않은 문제 -> BFS , dijkstra 
import sys
from collections import defaultdict,deque
INF = int(1e9) ## 최댓값 -> min 테이블에서 쓸거
def bfs(dic):
    global X,K
    state=False
    q = deque([X])
    visit_table[X] = True 
    min_dis_table[X] = 0
    while q:
        cur_x = q.popleft()
        try:
            for i in dic[cur_x]:
                if not visit_table[i]:
                    q.append(i)
                    visit_table[i] = True
                    min_dis_table[i] = 1+min_dis_table[cur_x]
                    if min_dis_table[i] == K:
                        state = True
        except:
            continue
    return state

input=sys.stdin.readline
N,M,K,X = map(int,input().split( )) ## K만큼 걸리는 곳 출력 ##X가 출발도시
dic = {}
[ (lambda k,v: dic.setdefault(k,[]).append(v))(*map(int, input().split()))
  for _ in range(M) ]
visit_table = [False]*(N+1)
min_dis_table = [INF]*(N+1)
if not bfs(dic):
    print("-1")
else: [print(i,sep="\n") for i, j in enumerate(min_dis_table) if j == K]