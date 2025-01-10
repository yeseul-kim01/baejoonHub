import sys
input = sys.stdin.readline

# N,*H = map(int,input().split())

N = int(input())
li = [int(input()) for _ in range(N)]

stack = []
sum = 0

for i in li:
  while stack and stack[-1] <= i:
    stack.pop()

  sum += len(stack)
  stack.append(i)

print(sum)