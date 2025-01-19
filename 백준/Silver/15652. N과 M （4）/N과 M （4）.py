n,m = map(int,input().split())
s = []

def back(x):
    if len(s) == m:
        print(*s)
        return
    for i in range(x,n+1):
        s.append(i)
        back(i)
        s.pop()

back(1)