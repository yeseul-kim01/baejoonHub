def check(): 
    result = []
    for y in range(N):
        for x in range(N):
            if classroom[y][x] == 0:
                likes, empty = 0, 0
                for dy, dx in move:
                    ny, nx = y + dy, x + dx
                    if 0 <= ny < N and 0 <= nx < N :
                        if classroom[ny][nx] in like: 
                            likes += 1
                        if classroom[ny][nx] == 0:
                            empty += 1
                result.append([y,x,likes, empty])
    return sorted(result, key=lambda x:(-x[2],-x[3],x[0],x[1])) 

import sys
N = int(sys.stdin.readline())
classroom = [[0]*N for _ in range(N)]
move = [[0,1],[1,0],[-1,0],[0,-1]]
student_like = {}
for _ in range(N*N):
    num, *like = map(int, sys.stdin.readline().split())
    student_like[num] = like
    x = check()
    classroom[x[0][0]][x[0][1]] = num

result = 0
for y in range(N):
    for x in range(N):
        temp = 0
        for dy, dx in move:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0<= nx < N:
                if classroom[ny][nx] in student_like[classroom[y][x]]: 
                    temp += 1 
        if temp > 0 :
            result += 10**(temp-1) 
print(result)
