from itertools import permutations
 
n, k = map(int, input().split())
arr = [[0]*(n+1) for _ in range(n+1)]
for i in range(1, n+1):
    input_data = list(map(int, input().split()))
    for j in range(1, n+1):
        arr[i][j] = input_data[j-1]
kh = list(map(int, input().split()))
mh = list(map(int, input().split()))
 
 
def dfs(p1, p2, idx, rsp, win):
    if win[0] == k: 
        return True
    if win[1] == k or win[2] == k:   
        return False
    if idx[0] == n: 
        return False
 
    if p1 > p2:
        p1, p2 = p2, p1
    p3 = 3 - (p1 + p2)  
 
    if arr[rsp[p1][idx[p1]]][rsp[p2][idx[p2]]] == 2:  
        win[p1] += 1
        idx[p1] += 1
        idx[p2] += 1
        return dfs(p1, p3, idx, rsp, win)
    else:   # p2 승
        win[p2] += 1
        idx[p1] += 1
        idx[p2] += 1
        return dfs(p2, p3, idx, rsp, win)
 
 
for jw in permutations(range(1, n+1)):
    rsp = [list(jw), kh, mh]   
    idx = [0] * 3  
    win = [0] * 3  
    if dfs(0, 1, idx, rsp, win):
        print(1)
        exit()
print(0)