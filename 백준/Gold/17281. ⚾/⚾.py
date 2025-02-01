import sys
from itertools import permutations
N = int(sys.stdin.readline())
game = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

order = [i for i in range(1,9)] 
result = float('-inf')
for x in permutations(order,8):
    x = list(x)
    batter = x[:3] + [0] + x[3:] 
    number, point = 0, 0
    for i in range(N): 
        out = 0
        p1 = p2 = p3 = 0 
        while out < 3: 
            if game[i][batter[number]] == 0:
                out += 1 
            elif game[i][batter[number]] == 1: 
                point += p3 
                p1, p2, p3 = 1, p1, p2
            elif game[i][batter[number]] == 2: 
                point += p2 + p3 
                p1, p2, p3 = 0, 1, p1
            elif game[i][batter[number]] == 3:
                point += p1 + p2 + p3
                p1, p2, p3 = 0, 0, 1
            elif game[i][batter[number]] == 4:
                point += p1 + p2 + p3 + 1
                p1, p2, p3 = 0, 0, 0
            number += 1 
            if number == 9:
                number = 0
    result = max(result, point)
print(result)
