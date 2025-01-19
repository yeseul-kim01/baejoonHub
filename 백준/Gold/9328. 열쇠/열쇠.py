import sys
input = sys.stdin.readline
from collections import *
sys.setrecursionlimit(10**7)

T = int(input())

def find(x, y) :
    global cnt
    visited[x][y] = 1

    for a, b in Dir :
        nx = x + a
        ny = y + b
        if 0<=nx<=h+1 and 0<=ny<=w+1 and visited[nx][ny] == 0 and I[nx][ny] != '*' :
            text = I[nx][ny]
            if text == '.' : find(nx, ny)
            elif text == '$' : cnt += 1 ; find(nx, ny)
            elif 97<=ord(text)<=122 : 
                Key.add(text) ; find(nx, ny)
                while Door[text] :
                    a, b = Door[text].pop()
                    find(a, b)
            else : 
                if text.lower() in Key : find(nx, ny)
                else : Door[text.lower()].append((nx, ny))
                
for _ in range(T) :
    h, w = map(int,input().split())
    I = ['.' * (w+2)]
    for _ in range(h) : I.append('.' + input().strip() + '.')
    I. append('.' * (w+2))
    Dir = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    visited=[[0] * (w+2) for _ in range(h+2)]
    t = input().strip()
    Key = set() ; Door = defaultdict(list)
    if t != '0' : 
        for a in t : Key.add(a)
    
    cnt = 0
    find(0, 0)
    print(cnt)