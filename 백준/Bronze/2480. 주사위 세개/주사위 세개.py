from collections import Counter
n = list(map(int,input().split(" ")))
sorted_d = dict(sorted(dict(Counter(n)).items(), key=lambda item: item[1], reverse=True))
s = len(sorted_d)
if s ==1:
    print(10000+n[0]*1000)
elif s==2:
    print(1000+100*next(iter(sorted_d.keys())))
elif s==3:
    print(100*max(n))