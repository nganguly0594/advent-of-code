def parse(data):
    return data

def part1(data):
    pass

def part2(data):
    pass

if __name__ == '__main__':
    with open('day9/input9.txt') as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))