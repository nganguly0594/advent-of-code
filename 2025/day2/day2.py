def parse(data):
    ranges = []

    for range in data[0].split(','):
        start, end = map(int, range.split('-'))
        ranges.append((start, end))
    
    return ranges

def part1(data):
    total = 0

    for start, end in data:
        for i in range(start, end + 1):
            curr = str(i)
            half = len(curr) // 2
            if len(curr) - half != half:
                continue
        
            if curr[:half] == curr[half:]:
                total += i
    
    return total

def part2(data):
    total = 0

    for start, end in data:
        for i in range(start, end + 1):
            curr = str(i)

            repeats = False

            for div in range(2, len(curr) + 1):
                if len(curr) % div != 0:
                    continue
            
                small_len = len(curr) // div

                same = True

                for j in range(0, len(curr) - small_len, small_len):
                    if curr[j:j + small_len] != curr[j + small_len:j + 2 * small_len]:
                        same = False
                        break
                
                if same:
                    repeats = True
                    break
            
            if repeats:
                total += i
    
    return total

if __name__ == "__main__":
    with open("day2/input2.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))