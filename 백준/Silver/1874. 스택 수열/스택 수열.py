n = int(input())
li = [int(input()) for _ in range(n)]

stack = []
string = ''
point_first = point_last = 0
point = li[0]
state = True

for i in li:
    if i >= point:
        point = point_last = i
        for i in range(point_first+1,point_last+1):
            stack.append(i)
            string += '+\n'
        point_first = point_last
    if i == stack.pop():
        string += '-\n'
    else:
        print('NO')
        state = False
        break
if state == True: 
    print(string)
