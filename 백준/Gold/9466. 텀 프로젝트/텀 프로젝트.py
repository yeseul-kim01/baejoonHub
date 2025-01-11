import sys
sys.setrecursionlimit(10**6)

def dfs(node):
    global data, visited, cycle
    visited[node] = True
    cycle.append(node)
    if visited[data[node]]:
        if data[node] in cycle:
            team.extend(cycle[cycle.index(data[node]):])
    else:
        dfs(data[node])


T = int(input())
for _ in range(T):
    N = int(input()) 
    visited = [False] * (N+1)
    data = [0] + list(map(int, input().split()))
    edge = [[] for _ in range(N+1)]
    team = [] 

    for i in range(1, N+1):
        if not visited[i]:
            cycle = []
            dfs(i)

    print(N - len(team))