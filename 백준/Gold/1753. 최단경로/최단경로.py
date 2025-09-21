#다익스트라 구현
# 우선순위 큐로 구현 (순차 탐색 시 시간 복잡도가 크게 나올 수 있음.)
# 현재까지 합해진 거리의 최솟값 배열 [min_dis table] 이 필요함
# 우선 순위 큐 안에는 <노드,간선의 크기> -> 
# 이때 간선의 크기는 해당 간선을 지날 때 더해지는 거리값임.

## 저장시 dic 으로 저장한다 -> a:(b,c)로 저장 .b는 가는 노드 , c는 가는데 걸리는 거리
import heapq ##힙 우선순위큐 저장

def dijkstra(k):##시작
    min_dist[k]=0
    h.heappush(result,[0,k])
    # print(result)
    while result:
        min_d,node = h.heappop(result)
        # print("result while:",node,min_d)
        if min_dist[node]<min_d:
            continue
        try : 
            for a,b in dic[node]:
                new_dis=min_d+b # 새로운 값 
                if new_dis < min_dist[a]:
                    min_dist[a] = new_dis
                    heapq.heappush(result,[new_dis,a])
        except :
            continue
import sys
import heapq ##힙 우선순위큐 저장
input = sys.stdin.readline
INF = int(1e9)##최대값
V,E = map(int,input().split())
## 정점 개수 V , 간선 개수 E
K = int(input()) ## start 노드
h = heapq
result = []
dic={} ## 저장할 dict
[(lambda u,v,w: dic.setdefault(u,[]).append((v,w)))
 (*map(int, input().split())) for _ in range(E)]

min_dist = [INF]*(V+1) ##최소거리 합 저장 
dijkstra(K)
# print(min_dist)
for i in min_dist[1:]:
    if i==INF:
        print("INF")
    else:
        print(i)