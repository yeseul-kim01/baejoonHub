import sys

std=sys.stdin.readline
for i in range(int(input())):
    print(sum(map(int,std().rstrip().split())))
    