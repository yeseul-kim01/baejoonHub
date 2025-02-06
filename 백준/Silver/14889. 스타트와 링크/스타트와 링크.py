import sys

def func(num,cnt):
    global answer

    if cnt==n//2: 
        team1=0
        team2=0

        for i in range(n):
            for j in range(n):

                if not visited[i] and not visited[j]:
                    team1+=arr[i][j]

                if visited[i] and visited[j]:
                    team2+=arr[i][j]
        
        answer=min(answer,abs(team1-team2))


    for i in range(num,n):
        if not visited[i]:
            visited[i]=True
            func(i,cnt+1)
            visited[i]=False

n=int(sys.stdin.readline())

arr=[]
for _ in range(n):
    arr.append(list(map(int,sys.stdin.readline().split())))

visited=[False]*n 

answer=1e9
func(0,0)

print(answer)