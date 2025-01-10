import sys
N=int(input()) #명령의 수
stack=[]
for _ in range(N):
    a = sys.stdin.readline().split() #입출력 속도
    if a[0]=='push':
        stack.append(a[1])
    elif a[0]=='pop':
        if len(stack)==0:
            print('-1')
        else:
            print(stack[-1])
            stack.pop()
    elif a[0]=='size':
        print(len(stack))
    elif a[0]=='empty':
        if len(stack)==0:
            print(1)
        else:
            print(0)
    else:
        if len(stack)==0:
            print('-1')
        else: print(stack[-1])