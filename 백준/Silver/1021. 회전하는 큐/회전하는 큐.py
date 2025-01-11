import sys
from collections import deque
input = sys.stdin.readline

N , M = map(int,input().split())
H = list(map(int,input().split( )))

deq = deque()
for i in range(1,N+1):
    deq.append(i)
sum = 0
for i in H:
    while True:
        if deq[0] == i:
            deq.popleft()
            break
        else:
            if deq.index(i) < len(deq)/2:
                while deq[0] != i:
                    deq.append(deq.popleft())
                    sum += 1
            else:
                while deq[0] != i:
                    deq.appendleft(deq.pop())
                    sum += 1
                
        
print(sum)