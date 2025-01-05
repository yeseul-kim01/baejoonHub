import sys
n = int(input())
for i in range(n):
    str1,str2=map(list,input().split())
    str1.sort()
    str2.sort()
    if str1 !=str2:
        print('Impossible')
    else:
        print('Possible')
        
