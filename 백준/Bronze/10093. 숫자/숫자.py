a,b=map(int,input().split(" "))
if a>b:
    t = a
    a = b
    b = t
len = b-a-1
if len>0:
    print(len)
    print(*list(range(a+1,b,1)))
else:
    print(0)