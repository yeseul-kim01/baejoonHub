n,m = map(int,input().split())
s = list(map(int,input().split()))
ans = []
s.sort()
# print(s)
def back():
    if len(ans) == m:
        print(*ans)
        return
    for i in s:
        if i not in ans:
            ans.append(i)
            back()
            ans.pop()

back()