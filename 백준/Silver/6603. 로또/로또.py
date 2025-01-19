import sys
ans = []

def back(x):
    global N, arr
    if len(ans) == 6:
        print(*ans)
        return
    for i in range (x,len(arr)):
        if arr[i] not in ans:
            ans.append(arr[i])
            back(i)
            ans.pop()
    
    return

while True:
    N, *arr = map(int,input().split())
    if N == 0 :
        break
    back(0)
    print()
    


    
    
    
    
