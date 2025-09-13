##힙 구현 ㄴㄴ , 시간 제한 6초 

import heapq
import sys

## 입력 값일 때 I N 으로 들어옴. -> 정렬 되어 있음. 삽입 하면 댐 
input = sys.stdin.readline

## 삭제 값일 때 D 1 은, 최댓값 삭제 : 맨 앞 값 삭제  - 같은거 있을 때 둘중 하나만 삭제 ,
# -1 은 최솟값 삭제 : 가장 끝에 값 삭제
t=int(input()) # t의 값 저장 
he=heapq
for i in range(t):
    n=int(input())
    ma_he=[]
    mn_he=[]
    rel=[False]*n
    x=0
    for j in range(n):
        a,b=input().split(" ")
        b=int(b)
        if a=="I":
            he.heappush(ma_he,(-b,x))
            he.heappush(mn_he,(b,x))
            rel[x]=True
            x+=1
            # print(" [최대힙]insert 검증용: ",ma_he,"에다가",b,"를 집어넣음")
            # print(" [최소힙]insert 검증용: ",mn_he,"에다가",b,"를 집어넣음")

        else:

            if b==1: # 최댓값 삭제임, rel 에서 살아남은 애만 
                while ma_he and not rel[ma_he[0][1]]:
                    he.heappop(ma_he) #쓰레기 버리기
                if ma_he:
                    pr=he.heappop(ma_he)
                    # print("실제 제거한 최댓값:",pr)
                    rel[pr[1]] = False # 실제 제거 후 relation 업데이트
                    
            else:
                while mn_he and not rel[mn_he[0][1]]:
                    he.heappop(mn_he)
                if mn_he:
                    pr = he.heappop(mn_he)
                    # print("실제 제거한 최솟값:",pr)
                    rel[pr[1]]= False
           
    # print(rel)         
    while mn_he and not rel[mn_he[0][1]]:
        he.heappop(mn_he)
    while ma_he and not rel[ma_he[0][1]]:
        he.heappop(ma_he)
    # print(mn_he)
    # print(ma_he)
    if not mn_he or not ma_he:
        print("EMPTY")
    else:
        print(-ma_he[0][0], mn_he[0][0])
                