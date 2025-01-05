import sys
from heapq import *
heap=[]
for x in [*open(0)][1:]: heappush(heap,[abs(y),y]) if (y:=int(x)) else ( print(heappop(heap)[1]) if heap else print(0))