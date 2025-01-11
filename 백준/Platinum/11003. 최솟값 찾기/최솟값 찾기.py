import sys
from collections import deque

input = sys.stdin.readline

N,L = map(int,input().rstrip("\n").split())
arr = list(map(int,input().split()))
deq = deque([])
for i in range(N):
    min = 0
    if deq and deq[0][0] <=i-L:
        deq.popleft()
    while len(deq) >=1 and arr[i]<deq[-1][1]:
        deq.pop()
    deq.append((i,arr[i]))
    print(deq[0][1],end=" ")