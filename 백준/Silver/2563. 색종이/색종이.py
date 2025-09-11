# 색종이 -> 이차원 배열 list 나 좌표값을 set으로 저장해서 풀면 될 듯
# 100개까지라 시간 복잡도가 높지 않아 하나씩 다 확인해도 괜찮을 거 같고, sys 안 써도 됨. input(), map 으로 하면 됨.

n=int(input()) # 총 색종이의 개수  - number of black papers
#두번째 입력값은 x,y 좌표임.
result= [[0]*100 for _ in range(100)]
sum=0
for _ in range(n):
    x,y = map(int,input().split(" "))
    for i in range(y,y+10): # 처음에 y 좌표
        for j in range(x,x+10):
            if result[i][j]==0:
                result[i][j]=1
                sum+=1
print(sum)

