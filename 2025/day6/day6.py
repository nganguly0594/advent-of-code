def parse(data):
    return data

def part1(data):
    problems = []

    for i, line in enumerate(data):
        if i == 0:
            for num in map(int, line.split()):
                problems.append([num])
        elif i < len(data) - 1:
            for j, num in enumerate(map(int, line.split())):
                problems[j].append(num)
        else:
            for j, op in enumerate(line.split()):
                problems[j].append(op)

    grand_total = 0

    for problem in problems:
        op = problem[-1]

        if op == '+':
            grand_total += sum(problem[:-1])
        else:
            prod = 1

            for num in problem[:-1]:
                prod *= num
            
            grand_total += prod
    
    return grand_total

def part2(data):
    grand_total = 0
    nums = []
    op = -1

    for i in range(len(data[0])):
        empty = True
        for j in range(len(data)):
            if data[j][i] != ' ':
                empty = False
                break
        
        if empty:
            if op == '+':
                grand_total += sum(nums)
            else:
                prod = 1

                for num in nums:
                    prod *= num
                
                grand_total += prod
            
            nums = []
            op = -1
            continue
        
        nums.append(0)
        for j in range(len(data) - 1):
            if data[j][i] == ' ':
                continue
            nums[-1] *= 10
            nums[-1] += int(data[j][i])

        if op == -1:
            op = data[-1][i]

    if op == '+':
        grand_total += sum(nums)
    else:
        prod = 1

        for num in nums:
            prod *= num
        
        grand_total += prod
    
    return grand_total

if __name__ == "__main__":
    with open("day6/input6.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))