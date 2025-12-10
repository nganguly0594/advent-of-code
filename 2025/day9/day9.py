from shapely.geometry import Polygon, box
def parse(data):
    points = []

    for line in data:
        points.append(tuple(map(int, line.split(','))))
    
    return points

def part1(data):
    points = data
    
    biggest = 0

    for i in range(len(points) - 1):
        p1x, p1y = points[i]

        for j in range(i + 1, len(points)):
            p2x, p2y = points[j]

            area = (abs(p1x - p2x) + 1) * (abs(p1y - p2y) + 1)

            biggest = max(biggest, area)
    
    return biggest

def part2(data):
    points = data
    poly = Polygon(points)

    biggest = 0

    for i in range(len(points) - 1):
        p1x, p1y = points[i]

        for j in range(i + 1, len(points)):
            p2x, p2y = points[j]

            rect = box(min(p1x, p2x), min(p1y, p2y), max(p1x, p2x), max(p1y, p2y))

            if poly.contains(rect):
                area = (abs(p1x - p2x) + 1) * (abs(p1y - p2y) + 1)
                biggest = max(biggest, area)
    
    return biggest

if __name__ == "__main__":
    with open("day9/input9.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))