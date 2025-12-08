def parse(data):
    fresh = True

    intervals = []
    ingredients = []

    for line in data:
        if not line:
            fresh = False
            continue
            
        if fresh:
            intervals.append(tuple(map(int, line.split('-'))))
        else:
            ingredients.append(int(line))
    
    intervals.sort()
    ingredients.sort()

    return intervals, ingredients

def part1(data):
    intervals, ingredients = data

    i, j = 0, 0
    fresh = 0

    while i < len(intervals) and j < len(ingredients):
        start, end = intervals[i]
        ing_id = ingredients[j]

        if ing_id < start:
            j += 1
        elif start <= ing_id <= end:
            j += 1
            fresh += 1
        else:
            i += 1

    return fresh

def part2(data):
    intervals, _ = data

    fresh = 0
    prev = -1

    for start, end in intervals:
        if end < prev:
            continue

        start = max(start, prev)
        fresh += end - start + 1
        prev = end + 1
    
    return fresh

if __name__ == "__main__":
    with open("day5/input5.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))