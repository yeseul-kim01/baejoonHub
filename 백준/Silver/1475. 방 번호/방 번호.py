n = input()
list =[0]*9
for i in n:   
    i = int(i)
    if i == 9:
        i =6
    list[i]+=1
if list[6]%2==0:
    list[6]=list[6]//2
else:
    list[6]=(list[6]-1)//2+1
print(max(list))