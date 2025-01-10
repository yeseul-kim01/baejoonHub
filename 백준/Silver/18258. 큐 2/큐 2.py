import sys
from collections import deque

deq=deque()

N=int(input())

for _ in range(N):
    cmd=sys.stdin.readline().strip().split()

    if cmd[0]=='push':
        deq.append(int(cmd[1]))

    elif cmd[0]=='pop':
        try:
            print(deq.popleft())
        except:
            print(-1)
 
    elif cmd[0]=='size':
        print(len(deq))

    elif cmd[0]=='empty':
        if deq:
            print(0)
        else:
            print(1)

    elif cmd[0]=='front':
        try:
            print(deq[0])
        except:
            print(-1)

    elif cmd[0]=='back':
        try:
            print(deq[-1])
        except:
            print(-1)