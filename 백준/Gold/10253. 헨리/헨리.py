import sys
from fractions import Fraction
input = sys.stdin.readline


def min_c(a,b):
    global result
    while a * result < b:
        result += 1
    return result

n = int(input())
for i in range(n):
    a, b = map(int,input().split(" "))
    sum = 0
    result = 2
    ## a/b 즉 a가 분자 b 가 분모
    n,m = a,b
    test = Fraction(a,b)
    if test.numerator == 1:
        print(test.denominator)
    while sum != a/b and a!=1:
        c = min_c(n,m)
        result += 1
        new=Fraction(n,m) - Fraction(1,c)
        new = Fraction(new)
        n = new.numerator
        m = new.denominator
        if n == 1:
            print(m)
            break
        sum += Fraction(1,c)        
