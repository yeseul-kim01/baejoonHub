import sys
import heapq as hp
heap =[]
for _ in range(int(input())):
    x = int(sys.stdin.readline())
    hp.heappush(heap,x) if x>0 else (print(hp.heappop(heap)) if len(heap)>0 else print(0))