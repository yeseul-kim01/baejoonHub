n,m = map(int,input().split())
s = []

def back(x):
    if len(s) == m:
        print(*s)
        return
    for i in range(x,n+1):
        if i not in s:
            s.append(i)
            back(i+1)
            s.pop()

back(1)