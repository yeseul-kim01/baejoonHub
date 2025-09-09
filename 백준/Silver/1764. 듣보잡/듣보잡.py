import sys
import collections
n,m=input().split(" ")
l = list(map(str.strip, sys.stdin.readlines()))
l.sort()
l1=collections.Counter(l)
r=[]
for j,i in l1.items():
    if i == 2:
        r.append(j)
print(len(r))
print(*r,sep="\n")