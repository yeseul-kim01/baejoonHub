import sys
N, L = map(int,sys.stdin.readline().split())
pan = []
for i in range(N):
    pan.append(list(map(int,sys.stdin.readline().split())))

answer = 0
def if_can_line(line):
    bri = [False for _ in range(N)]
    for i in range(1,N):
        if abs(line[i-1]-line[i])>1:
            return False
        else:
            if (line[i-1]-line[i])==1: 
                for j in range(L):
                    
                    if i+j>=N:
                        return False
                    if line[i]!=line[i+j]:
                        return False
                    if bri[i+j]==True:
                        return False
                    if bri[i+j]==False:
                        bri[i+j]=True
                    
            elif (line[i-1]-line[i])==-1: 
                for j in range(L):
                    if i-1-j<0:
                        return False
                    if line[i-1]!=line[i-1-j]:
                        return False
                    if bri[i-1-j]==True:
                        return False
                    if bri[i-j-1]==False:
                        bri[i-j-1]=True
    return True

for i in range(N):
    if if_can_line(pan[i]):
        answer+=1
for j in range(N):
    if if_can_line([pan[i][j] for i in range(N)]):
        answer+=1

print(answer)