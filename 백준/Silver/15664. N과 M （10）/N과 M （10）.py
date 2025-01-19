n,m = map(int,input().split())
s = list((map(int,input().split())))
ans = []
visit = [False]*n
s.sort()

def back(x):
    if len(ans) == m:
        print(*ans)
        return
    value = -1
    for i in range (x,n):
        if visit[i] != True and s[i] != value:
            value = s[i]
            ans.append(s[i])
            visit[i] = True
            back(i+1)
            visit[i] = False
            ans.pop()

back(0)