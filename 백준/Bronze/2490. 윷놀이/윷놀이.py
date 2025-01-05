for i in range(3):
    n = list(map(int,input().split( )))
    count = 0
    for i in n:
        if i ==1:
            count+=1
    if count == 0:
        str = 'D'
    elif count ==1:
        str = 'C'
    elif count ==2:
        str = 'B'
    elif count ==3:
        str ='A'
    else:
        str = 'E'
    print(str)