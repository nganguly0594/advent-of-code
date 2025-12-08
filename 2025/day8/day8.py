import heapq

class DSU:
    def __init__(self, n):
        self.par = list(range(n))
        self.size = [1] * n
        self.comps = n
    
    def find(self, a):
        if self.par[a] != a:
            self.par[a] = self.find(self.par[a])
        return self.par[a]
    
    def union(self, a, b):
        par_a = self.find(a)
        par_b = self.find(b)

        if par_a == par_b:
            return
        
        if self.size[par_a] < self.size[par_b]:
            par_a, par_b = par_b, par_a
        
        self.par[par_b] = par_a
        self.size[par_a] += self.size[par_b]
        self.comps -= 1

def parse(data):
    points = []

    for line in data:
        points.append(tuple(map(int, line.split(','))))
    
    edges = []

    for i in range(len(points) - 1):
        p1x, p1y, p1z = points[i]
        for j in range(i + 1, len(points)):
            p2x, p2y, p2z = points[j]

            dist = (p1x - p2x) ** 2 + (p1y - p2y) ** 2 + (p1z - p2z) ** 2

            edges.append((dist, i, j))

    edges.sort()
    
    return points, edges

def part1(data):
    points, edges = data

    dsu = DSU(len(points))

    iters = 10 if len(points) == 20 else 1000

    for i in range(iters):
        _, a, b = edges[i]
        dsu.union(a, b)
    
    biggest = []

    for i in range(len(points)):
        if dsu.par[i] == i:
            heapq.heappush(biggest, dsu.size[i])

            if len(biggest) > 3:
                heapq.heappop(biggest)
    
    return biggest[0] * biggest[1] * biggest[2]

def part2(data):
    points, edges = data

    dsu = DSU(len(points))
    p1, p2 = -1, -1

    for _, a, b in edges:
        dsu.union(a, b)
        
        if dsu.comps == 1:
            p1, p2 = a, b
            break
    
    return points[p1][0] * points[p2][0]

if __name__ == "__main__":
    with open("day8/input8.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))