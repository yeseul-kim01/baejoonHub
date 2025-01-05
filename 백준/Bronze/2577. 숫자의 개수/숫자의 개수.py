a,b,c=int(input()),int(input()),int(input())
a=a*b*c
list=[0]*10
for i in str(a):
    list[int(i)]+=1
print(*list,sep="\n")