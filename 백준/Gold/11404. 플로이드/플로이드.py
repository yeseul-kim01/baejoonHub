##다익스트라 구현 
## 시작 노드 , 종료 노드 
import sys
import heapq ##최소힙으로 구현해야 할 듯 
input = sys.stdin.readline
INF = int(1e9) ## 최댓값 

def dijkstra(x): ##x는 첫 시작 노드 고정
    min_dist[x]=0 ## 첫 시작 노드에서 첫 시작노드까지의 거리는 0 이니까.
    h.heappush(result,[0,x]) ## 저장 시 최소힙 구현을 위해 거리를 맨 앞, 뒤가 노드
    while result: ## result 가 비워지기전까지 반복해야 함.
        cu_dis,cu_node = h.heappop(result) ## 가장 작은 거리값인 거 빼기
        if cu_dis > min_dist[cu_node]:
            # print(cu_dis,cu_node)
            continue ## 새로운 거리 보다 기존 거리가 적으면 업데이트 안함.
        try:
            for new_node,new_dis in dic[cu_node]: ## 새로운 거 
                if (update_dis:=new_dis+cu_dis)>min_dist[new_node]: 
                    ##새로운 노드의 거리값이 새로 움직인 경로값보다 작으면 continue
                    continue
                min_dist[new_node]=update_dis ##아니니까 업데이트해줘야함.
                # print("min_dist 업데이트:","new_node:",new_node,"min_dist:",update_dis,"더해진 값:",cu_dis)
                h.heappush(result,[update_dis,new_node]) ## 새로운 경로랑 새 노드 추가
        except: continue        
    return 

N=int(input())
M=int(input())
h = heapq ##힙 함수
dic = {} ## 딕셔너리 - 단방향이니까 
[(lambda a,b,c :dic.setdefault(a,[]).append((b,c))) 
 (*map(int,input().split())) 
 for _ in range(M)]
# print(dic)
for i in range(1,N+1): ## 총 N줄 출력
    min_dist=[INF]*(N+1) ## 최솟값 담는 배열 
    result = [] ## 큐로 사용할 곳 (min_dis,node) - 로 저장
    dijkstra(i) ## 첫 시작 노드
    for i in min_dist[1:]:
        if i == INF:
            print("0",end=" ")
        else:
            print(i,end=" ")
            
    print()
    