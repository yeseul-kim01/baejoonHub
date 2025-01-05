import sys
import heapq as hq
N=int(input())
S = [list(map(int,sys.stdin.readline().split())) for _ in range (N)]
S.sort(key= lambda x:x[0])

lec_room = []
hq.heappush(lec_room, S[0][1])
for i,j in S[1:]:
    if i<lec_room[0]:
        hq.heappush(lec_room,j)
    else:
        hq.heappop(lec_room)
        hq.heappush(lec_room,j)
print(len(lec_room))