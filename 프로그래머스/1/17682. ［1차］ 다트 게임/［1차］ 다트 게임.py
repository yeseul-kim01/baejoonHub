import re

def solution(dartResult):
    answer = 0
    result=[]
    part = re.findall(r'\d+|[A-Za-z]+|[^A-Za-z0-9\s]+',dartResult)
    idx = 0 ##index 위치
    a=b=c=1
    for j,i in enumerate (part):
        if i.isdigit():
            a = int(i)
        elif i.isalpha():
            if i =="T": b =3
            elif i =="D": b=2
            else: b=1
        else:
            print("심볼들어옴:",i)
            if i =="#":
                c = -1
            else:
                c = 2
                if idx!=0: 
                    result[idx-1]*=2   
                
        if (j<len(part)-1 and part[j+1].isdigit()) or j == len(part)-1:
            idx+=1
            result.append(example(a,b,c))
            print(result)
            a=b=c=1
    return result[0]+result[1]+result[2]

def example(a,b,c):
    return (a**b)*c


## 총 3번의 기회
## 0~10점까지