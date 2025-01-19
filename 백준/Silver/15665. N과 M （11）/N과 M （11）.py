n,m = map(int,input().split())
s = list((map(int,input().split())))
ans = []
s.sort()

def back(x):
    if len(ans) == m:
        print(*ans)
        return
    value = -1
    for i in range (n):
        if s[i] != value:
            value = s[i]
            ans.append(s[i])
            back(i)
            ans.pop()

back(0)