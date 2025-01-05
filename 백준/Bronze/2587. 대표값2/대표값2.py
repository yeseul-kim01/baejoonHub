sum = 0
list=[]
for _ in range(5):
    n = int(input())
    list.append(n)
    sum += n
list.sort()
print(sum//5)
print(list[2])
    
    