N,S =map(int,input().split())
arr = list(map(int,input().split()))
cnt = 0
ans = []
def back(x):
    global cnt
    if sum(ans) == S and len(ans) > 0 :
        cnt += 1
        # print(cnt)
    for i in range(x, N):
        ans.append(arr[i])
        # print(x,i,ans)
        back(i+1)
# print('--',x,i,ans)
        ans.pop()
        
back(0)
print(cnt)


    