n = int(input())
for i in range(n):
    print('*'*(i+1) + ' '*2*(n-i-1) + '*'*(i+1))
for i in range(n-1):
    print('*'*(n-i-1) + ' '*2*(i+1) + '*'*(n-i-1))
