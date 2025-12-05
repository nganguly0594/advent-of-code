def parse(data):
    nums = []

    for line in data:
        num = int(line[1:])
        nums.append((-1 if line[0] == 'L' else 1, num))
    
    return nums

def part1(data):
    ret = 0
    curr = 50

    for sign, num in data:
        num %= 100
        curr = (curr + sign * num) % 100
        
        if not curr:
            ret += 1
    
    return ret

def part2(data):
    ret = 0
    curr = 50

    for sign, num in data:
        ret += num // 100
        num %= 100

        prev = curr
        curr += sign * num

        if (prev and (curr < 0 or curr > 99)):
            ret += 1
        
        if not curr:
            ret += 1
        
        curr %= 100
    
    return ret

if __name__ == "__main__":
    with open("day2/test2.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))