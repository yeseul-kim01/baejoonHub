
sum=0
min=100
for _ in range(7):
    i = int(input())
    if i %2 !=0:
        sum +=i
        if min >=i:
            min = i
if sum!=0:
    print(sum)
    print(min)
else:
    print(-1)