n = int(input())
count = [0]*(n+1) # 인덱스 0 넣기
min_x=0
for i in range(2,n+1): 
    if i==2 or i==3:
        count[i]=1
        min_x=1
    else:
        min_x=count[i-1]+1
        if i%2==0:
            if (min_x>(a:=count[i//2]+1)):
                min_x=a
        if i%3==0:
            if (min_x>(b:=count[i//3]+1)):
                min_x=b
        count[i]=min_x
print(min_x)