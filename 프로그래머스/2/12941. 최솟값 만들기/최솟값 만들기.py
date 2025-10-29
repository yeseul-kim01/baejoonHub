## 5분 

def solution(A,B):
    answer = 0

    A.sort()
    B.sort(reverse=True)
    print(A,B)
    for i in range(len(A)):
        answer += A[i]*B[i]
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    print('Hello Python')

    return answer

# A,B 자연수 - 길이 같은 배열임 A에서 가장 작은 숫자와 B에서 가장 큰 숫자 뽑아서 곱하면 됨.
# 최소힙과 최대힙으로 넣어서 뽑거나 정렬을 사용해야 될 듯 