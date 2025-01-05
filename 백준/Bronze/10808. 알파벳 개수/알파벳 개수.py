from collections import Counter
import string

n = input()
my_dict = {char: 0 for char in string.ascii_lowercase} 

counter = Counter(n.lower())  


for char, count in counter.items():
    if char in my_dict: 
        my_dict[char] = count

sorted_d = dict(sorted(my_dict.items(), key=lambda item: item[0]))

print(*sorted_d.values())
