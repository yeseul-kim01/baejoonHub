import sys
from collections import deque

deq=deque()

N=int(input())

for _ in range(N):
    cmd=sys.stdin.readline().strip().split()
    
    if cmd[0] =='push_front':
        deq.appendleft(int(cmd[1]))
    elif  cmd[0] =='push_back':
        deq.append(int(cmd[1]))
    elif  cmd[0] =='pop_front':
        try:
            print(deq.popleft())
        except:
            print(-1)
    elif  cmd[0] =='pop_back':
        try:
            print(deq.pop())
        except:
            print(-1)
    elif  cmd[0] =='size':
        print(len(deq))
    elif cmd[0] =='empty':
        if len(deq) == 0:
            print(1)
        else:
            print(0)
    elif  cmd[0] =='front':
        try:
            print(deq[0])
        except:
            print(-1)
    else:
        try:
            print(deq[-1])
        except:
            print(-1)
    