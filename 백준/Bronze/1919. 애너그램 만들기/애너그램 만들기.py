def intersection_with_duplicates(list1, list2):
    list1.sort()
    list2.sort()  
    
    i, j = 0, 0
    intersection = []
    
    while i < len(list1) and j < len(list2):  
        if list1[i] == list2[j]:
            intersection.append(list1[i])
            i += 1
            j += 1
        elif list1[i] < list2[j]:
            i += 1
        else:
            j += 1
            
    return intersection

str1,str2=list(input()),list(input())
count=len(intersection_with_duplicates(str1,str2))
print(len(str1)+len(str2)-count*2)