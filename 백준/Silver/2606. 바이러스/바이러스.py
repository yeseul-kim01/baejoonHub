#BFS , 20606
import sys
from collections import deque,defaultdict
def bfs():
    q = deque([1]) # 처음에 무조건 1에서 시작하니까 
    result = 0
    visit[0] = True
    while q:
        cur = q.popleft()
        for i in (dic[cur]):
            # print("현재:",cur,"i 값:",i)
            if not visit[i-1]:
                q.append(i)
                visit[i-1]=True
                result+=1
                # print("추가할 거",i)
    return result

# n, link, *l = (int(line) if i < 2 else list(map(int, line.split()))
#                for i, line in enumerate(open(0)))
n = int(input())
link = int(input())
l = [list(map(int,sys.stdin.readline().split(" "))) for _ in range(link)]
dic=defaultdict(list)
result = 0 # 감염 컴퓨터 수
visit = [False]*n
for i ,j in (l) :
    dic[i].append(j)
    dic[j].append(i)
# print(dic)
print(bfs())