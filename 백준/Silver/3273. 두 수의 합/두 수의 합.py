
import sys
n,list,x=int(input()),list(map(int,sys.stdin.readline().rstrip().split(" "))),int(input())
s=0
st=0
end=n-1
list.sort()
while st<end:
    r = list[st]+list[end]
    if x== r:
        s+=1
    if x>=r:
        st+=1
    else:
        end-=1
print(s)
            
