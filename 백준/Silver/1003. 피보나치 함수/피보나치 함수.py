sum_z=[1,0,1]
sum_o=[0,1,1]

def sum_fibo_zero_and_one(n):
    for i in range(len(sum_z),n+1):
        sum_z.append(sum_z[i-2]+sum_z[i-1])
        sum_o.append(sum_o[i-2]+sum_o[i-1])
    print(sum_z[n],sum_o[n])
    return 

T = int(input())
for i in range(T):
    sum_fibo_zero_and_one(int(input()))