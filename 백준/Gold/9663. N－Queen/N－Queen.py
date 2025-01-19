

def available(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) ==x-i:
            return False
    return True

def back(x):
    global cnt
    
    if x == N:
        cnt += 1
    else: 
        for i in range(N):
            row[x] = i
            if available(x):
                back(x+1)

N = int(input())
row = [0]*N
cnt = 0

back(0)
print(cnt)