import sys
from collections import deque

input = sys.stdin.readline

T = int(input())
 
for i in range(T):
    error = False
    P = input().strip()
    N = int(input())
    arr = deque(input()[1:-2].split(","))

    reverse = False
    
    if N == 0:
        arr = deque()
    
    for p in P:
        if p =='R':
            if reverse == True:
                reverse = False
            else :
                reverse = True  
        elif p =='D':
            if len(arr)==0:
                print("error")
                error = True
                break
            else:
                if reverse == True:
                    arr.pop()
                else:
                    arr.popleft()
    if not error:               
        if reverse:
            arr.reverse()
        print(f"[{','.join(map(str, arr))}]")     