arr =[]
for i in range(N:=int(input())):
    arr.append(list(map(int,input().split(" "))))
arr.sort(key= lambda x : (x[1],x[0]))

for res in arr:
    print(f"{res[0]} {res[1]}")
