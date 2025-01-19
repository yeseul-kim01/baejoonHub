N=int(input())
room=[list(map(int,input().split())) for _ in range(N)]
black=[]
white=[]
color=[[0]*N for _ in range(N)]

for x in range(N):
    for y in range(N):
        if (x+y)%2==0:
            color[x][y]=0
            if room[x][y]==1:
                black.append((x,y))
        else:
            color[x][y]=1
            if room[x][y]==1:
                white.append((x,y))

w_cnt=0
b_cnt=0
da=[False]*(2*N-1)
da_2=[False]*(2*N-1)

def put(box,index,count):
    global w_cnt,b_cnt
    if index==len(box):
        if box==white:
            w_cnt=max(w_cnt,count)

        else:
            b_cnt=max(b_cnt,count)

        return

    x,y=box[index]
    if da[x+y] or da_2[x-y+N-1]:
        put(box,index+1,count)
    else:
        da[x+y]=True
        da_2[x-y+N-1]=True
        put(box,index+1,count+1)
        da[x+y]=False
        da_2[x-y+N-1]=False
        put(box,index+1,count)


if len(white)>0:
    put(white,0,0)
if len(black)>0:
    put(black,0,0)

print(w_cnt+b_cnt)