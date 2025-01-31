import sys
arr =[]
for i in range(N:=int(input())):
    arr.append(list(map(int,input().split(" "))))
arr.sort(key= lambda x : (x[0],x[1]))

for res in arr:
    print(f"{res[0]} {res[1]}")
