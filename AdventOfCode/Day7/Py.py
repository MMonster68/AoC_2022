import sys
from collections import defaultdict
infile = 'data.dat'
data = open(infile).read().strip()
#data is now equal to data.dat but without whitespace
lines = [x for x in data.split('\n')]
#creates an array with an index at every new line

# directory path -> total size of that directory (including subdirectories)
SZ = defaultdict(int)
path = []
for line in lines:
    #line is a variable for each index, kinda like ifi function
    words = line.strip().split()
    #creates a list for every index in the lines list, and separates index by words
    if words[1] == 'cd':
        if words[2] == '..':
            path.pop()
        else:
            path.append(words[2])
            # After every line, prints out every open directery in a list.
            # If a directory is opened, it is added to the list, if one is closed, it is removed from the list
    elif words[1] == 'ls':
        continue
    elif words[0] == 'dir':
        continue
        # All listed Directories are ignored
    else:
        sz = int(words[0])
        # Add this file's size to the current directory size *and* the size of all parents
        for i in range(1, len(path)+1):
            SZ['/'.join(path[:i])] += sz
            # SZ['/'.join(path[:i])] writes out the path of every open directory seperated by / for every new term
            # sz takes the newest file size number for the current directory and adds it to the current directory and all smaller directories
            # example: directory = "a/b/c/d/e" and size = "10"
            # a: 10, a/b: 10, a/b/c: 10, a/b/c/d: 10, a/b/c/d/e: 10
            # also all elements of the same directory combine, so if directory "a/b" is added twice, value will be sum

max_used = 70000000 - 30000000
total_used = SZ['/']
need_to_free = total_used - max_used

E = []
for i, a in SZ.items():
    if a <= 100000:
        E.append(a)

print(E)

p1 = 0
p2 = 1e9
for k,v in SZ.items():
    #print(k,v)
    if v <= 100000:
        p1 += v
    if v>=need_to_free:
        p2 = min(p2, v)
print(p1)
#print(p2)