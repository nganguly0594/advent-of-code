def parse(data):
    return data

def part1(data):
    total_joltage = 0

    for line in data:
        left = int(line[-2])
        right = int(line[-1])

        for i in range(len(line) - 3, -1, -1):
            digit = int(line[i])

            if digit >= left:
                right = max(right, left)
                left = digit
        
        total_joltage += left * 10 + right
    
    return total_joltage

def part2(data):
    total_joltage = 0

    for line in data:
        nums = list(map(int, line[-12:]))

        for i in range(len(line) - 13, -1, -1):
            digit = int(line[i])

            if digit >= nums[0]:
                prev = nums[0]
                nums[0] = digit

                for i in range(1, 12):
                    if prev < nums[i]:
                        break
                        
                    prev, nums[i] = nums[i], prev
        
        joltage = 0

        for i in range(12):
            joltage += nums[11 - i] * (10 ** i)

        total_joltage += joltage
    
    return total_joltage

if __name__ == "__main__":
    with open("day3/input3.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))