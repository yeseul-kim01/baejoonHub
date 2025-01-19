n,m = map(int,input().split())
s = list(map(int,input().split()))
ans = []
s.sort()
# print(s)
def back(x):
    if len(ans) == m:
        print(*ans)
        return
    for i in range (x,n):
        if s[i] not in ans:
            ans.append(s[i])
            back(i+1)
            ans.pop()

back(0)