import sys
from collections import deque
MAX = sys.maxsize
input = sys.stdin.readline
N = int(input())
person = [0] + list(map(int, input().split()))
arr = [[] for _ in range(N+1)]
for i in range(1, N+1):
    temp = deque(map(int, input().split()))
    temp.popleft()
    arr[i] = list(temp)


def bfs(area):
    q = deque()
    visited = [False] * (N+1)
    q.append(area[0])
    visited[area[0]] = True
    temp = 0
    count = 1
    while q:
        node = q.popleft()
        temp += person[node]
        for nnode in arr[node]:
            if nnode in area and not visited[nnode]:
                visited[nnode] = True
                count += 1
                q.append(nnode)
    if count == len(area):
        return temp


def choose(n, count):
    global result
    if count == n:
        area1, area2 = [], []
        for i in range(1, N+1):
            if visited[i]:
                area1.append(i)
            else:
                area2.append(i)
        x, y = bfs(area1), bfs(area2)
        if x and y:
            result = min(result, abs(x-y))
        return
    for i in range(1, N+1):
        if not visited[i]:
            visited[i] = True
            choose(n, count+1)
            visited[i] = False


result = MAX
for i in range(1, N // 2 + 1):
    visited = [False]*(N+1)
    choose(i, 0)

if result == MAX:
    print(-1)
else:
    print(result)