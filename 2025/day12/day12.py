def parse(data):
    *shapes, areas = data.split('\n\n')

    sizes = [sum(c == '#' for c in shape) for shape in shapes]

    return sizes, areas

def part1(data):
    sizes, areas = data

    possible = 0

    for line in areas.splitlines():
        dims, *counts = line.split()
        a, b = tuple(map(int, dims[:-1].split('x')))
        available = a * b
        required = 0

        for i, count in enumerate(map(int, counts)):
            required += count * sizes[i]
        
        if required <= available:
            possible += 1
    
    return possible

if __name__ == "__main__":
    with open("day12/input12.txt") as f:
        data = f.read()
    
    data = parse(data)
    print(part1(data))