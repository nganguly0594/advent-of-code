from collections import defaultdict

def parse(data):
    return data

def part1(data):
    start = -1

    for i, c in enumerate(data[0]):
        if c == 'S':
            start = i
            break
    
    curr = set([start])
    splits = 0

    for line in data[1:]:
        next = curr.copy()

        for i, c in enumerate(line):
            if c == '^' and i in curr:
                next.remove(i)
                next.add(i - 1)
                next.add(i + 1)
                splits += 1
        
        curr = next
    
    return splits

def part2(data):
    start = -1

    for i, c in enumerate(data[0]):
        if c == 'S':
            start = i
            break
    
    curr = defaultdict(int)
    curr[start] = 1

    for line in data[1:]:
        next = curr.copy()

        for i, c in enumerate(line):
            if c == '^' and i in curr:
                next[i - 1] += next[i]
                next[i + 1] += next[i]
                next[i] = 0
        
        curr = next
    
    return sum(curr.values())

if __name__ == "__main__":
    with open("day7/input7.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))