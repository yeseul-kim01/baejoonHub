
num = 0
t_std_c , k = map(int,input().split())
array = [[0] * 2 for _ in range(6)]


for i in range(t_std_c):
    gender , cls =  map(int,input().split())
    array[cls-1][gender] +=1

for i,j in array:
    for a in (i,j):
        if (a !=0):
            if (a%k!=0):
                num +=1
            max_c = a // k
            num += max_c
print(num)