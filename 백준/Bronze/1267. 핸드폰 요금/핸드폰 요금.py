
import sys
n=int(input())
li = list(map(int,sys.stdin.readline().rstrip("/n").split(" ")))
Y=10*n
M=15*n
for i in li:
    Y+=(i // 30)*10
    M+=(i// 60)*15
if M==Y:
    print('Y M',M)
else:
    if M>Y:
        print('Y',Y)
    else:
        print('M',M)