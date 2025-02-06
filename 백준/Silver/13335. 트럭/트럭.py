import sys
import queue

n,w,L,*arr= map(int,sys.stdin.read().split())
#n 개의 트럭, 다리위에 w대만 올라갈 수 잇음. 
# 전체 무게는 L보다 작아야 됨
#arr 트럭 무게 순서임
#최단시간
min_time = 0
q = queue.Queue()
sum = 0
idx = 0
for i in range(w):
    q.put(0)

while idx < n:
    min_time +=1
    x = q.get()
    sum -= x
    if L-sum>=arr[idx]:
        q.put(arr[idx])
        sum+=arr[idx]
        idx+=1
    else : 
        q.put(0)
        
while not q.empty():
    min_time += 1
    q.get()
    
print(min_time)
        
    
