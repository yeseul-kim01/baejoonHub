arr = []
for i in range(N:=int(input())):
    k = int(input())
    arr.append(k)
arr.sort(reverse=True)
print(*arr,sep="\n") 