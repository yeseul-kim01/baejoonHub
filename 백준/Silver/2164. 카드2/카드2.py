import sys
from collections import deque
N =int(sys.stdin.readline())
que =deque(i+1 for i in range (N))
while len(que)!=1:
    que.popleft()
    que.append(que[0])
    que.popleft()
print(que[0])