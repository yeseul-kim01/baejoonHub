n,m = map(int,input().split())
s = []

def back():
    if len(s) == m:
        print(*s)
        return
    for i in range(1,n+1):
        s.append(i)
        back()
        s.pop()

back()