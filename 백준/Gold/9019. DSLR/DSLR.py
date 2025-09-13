##백준 9019
import sys
from collections import deque
input = sys.stdin.readline

def D(x): # 연산 함수 
    x = x*2
    if x>9999:
        x = x%10000 # 나머지
    return x

def S(x):
    if x==0:
        return 9999
    else : return x-1
    
def L(x):
    dx=x*10
    return (dx%10000) + (dx//10000)

def R(x):
    dx=x//10
    return dx + (x%10)*1000


## 함수_BFS  , a 는 처음 들어온 숫자 b는 결과값 
def algo(a,b):
    q=deque([a]) #처음 값 저장 -> 연산 시 나온 숫자들 다 저장할 거임.
    v=[False]*10000 #무조건 10000미만의 숫자임. 4자리니까 
    v[a]=True # 처음 들어온 숫자는 무조건 방문을 했으니까 True 로 바꿔주면 될듯.  
    s_op=[""]*10000 #그전까지의 연산기록
    s_pr=[-1]*10000 #그전까지의 숫자기록(음수는 없으니까 음수로 넣어두면 될듯)
    while q: #(q가 비어질 때 까지)
        x=q.popleft()
        if (x)==b:
            break
        else:
            ##연산 시작 (기록 위해 연산과정이랑 결과값 도출 저장해야됨.)
            for i,j in (("D",D(x)),("S",S(x)),("L",L(x)),("R",R(x))):
                if not v[j]: #반출된 결과값에 대한 방문 기록이 없으면 
                    v[j]=True #방문 여부 바꾸고
                    s_op[j]=i #연산기록 저장하고
                    s_pr[j]=x #이전 숫자기록 저장하기, 연산 전 숫자
                    q.append(j) #데큐 업데이트
            
    result=[]#전체연산기록      
    d_b=b
    while d_b!=a:
        result.append(s_op[d_b])
        d_b=s_pr[d_b]
    result.reverse()
    return result

t=int(input())

for i in range(t):
    sum_min=0
    a,b=map(int,input().split(" "))
    print(*algo(a,b),sep="")
