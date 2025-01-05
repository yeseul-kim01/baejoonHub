from itertools import combinations

l = [int(input()) for _ in range(9)]
result = list(combinations(l,7))
for c in result:
    if sum(c) ==100:
        c = list(c)
        c.sort()
        print(*c,sep="\n")
        break