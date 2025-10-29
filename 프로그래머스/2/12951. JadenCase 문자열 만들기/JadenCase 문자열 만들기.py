def solution(s):
    answer = ''
    state = True
    for i in s:
        if i.isalpha():
            if state == True:
                answer += i.upper()
            else:
                answer += i.lower()
        elif i == " ":
            answer+= i
            state = True
            continue
        else:
            answer+=i
        state = False
    return answer