def parse(data):
    return data[0]

def part1(data):
    memory = data
    left, right = 0, len(memory)

    end_id = len(memory) // 2
    
    check_sum = 0
    free = 0
    curr_id = 0
    true_idx = 0

    while left < right or (left == right and not free):
        block = int(memory[left])

        if not free:
            for i in range(true_idx):
                continue

        free ^= 1


def part2(data):
    pass

if __name__ == '__main__':
    with open('day9/test9.txt') as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))