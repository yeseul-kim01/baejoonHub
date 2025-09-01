#브루트포스 알고리즘 -> 다 해봐야댐. 하나씩 바꿔보고 최댓값 변경 있으면 변경해주면 됨. 
# 최대계산함수 하나 만들고 main 

# def print_arr(s):
#     # for i in range(n):
#     #     print(*s[i])
#     # print('')
def max_found(s):
    f_max = 0
    s_max = 0
    # 옆으로 최대 계산
    for i in range(n):
        s_max=1 # 무조건 하나는 있으니까
        for j in range(n-1):
            if (s[i][j] ==s[i][j+1]):
                s_max+=1
                # if (s_max > f_max) :
                    # print_arr(s)
                f_max = max(s_max,f_max)
            else:
                s_max=1
    for i in range(n):
        s_max=1 # 무조건 하나는 있으니까
        for j in range(n-1):
            if (s[j][i] ==s[j+1][i]):
                s_max+=1
                # if (s_max > f_max) :
                    # print_arr(s)
                f_max = max(s_max,f_max)
            else:
                s_max=1
    #밑으로 최대 계산
    # for i in range(n-1):
    #     s_max=1
    #     for j in range(n):
    #         if(s[i][j]==s[i+1][j]):
    #             s_max+=1
    #             # if (s_max > f_max) :
    #             #     # print_arr(s) 
    #             f_max = max(s_max,f_max)
    #         else:
    #             s_max=1

    return f_max



import sys
n = int(input())
s = [list(sys.stdin.readline().strip()) for _ in range(n)]
result = max_found(s)

for i in range(n):
    for j in range(n):
        if i<=n-2:
            s[i][j],s[i+1][j] = s[i+1][j],s[i][j] #밑 바꾸기
            ans = max_found(s)
            result = max(result,ans)
            s[i+1][j],s[i][j] = s[i][j],s[i+1][j] #원상복귀
            
        if j<=n-2:
            s[i][j],s[i][j+1] = s[i][j+1],s[i][j]#옆 바꾸기
            ans = max_found(s)
            result = max(result,ans)
            s[i][j+1],s[i][j] = s[i][j],s[i][j+1] #원상복귀

print(result)
