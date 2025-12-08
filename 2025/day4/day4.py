from collections import defaultdict, deque

def parse(data):
    graph = []

    for line in data:
        graph.append(list(line))

    adj_list = defaultdict(set)

    m, n = len(graph), len(graph[0])

    for i in range(m):
        for j in range(n):
            if graph[i][j] == '.':
                continue

            adj_list[(i, j)]
                
            if i + 1 < m:
                if j - 1 >= 0 and graph[i + 1][j - 1] == '@':
                    adj_list[(i, j)].add((i + 1, j - 1))
                    adj_list[(i + 1, j - 1)].add((i, j))
                
                if graph[i + 1][j] == '@':
                    adj_list[(i, j)].add((i + 1, j))
                    adj_list[(i + 1, j)].add((i, j))
                
                if j + 1 < n and graph[i + 1][j + 1] == '@':
                    adj_list[(i, j)].add((i + 1, j + 1))
                    adj_list[(i + 1, j + 1)].add((i, j))
            
            if j + 1 < n and graph[i][j + 1] == '@':
                adj_list[(i, j)].add((i, j + 1))
                adj_list[(i, j + 1)].add((i, j))
    
    return adj_list

def part1(data):
    accessible = 0

    for neighbors in data.values():
        if len(neighbors) < 4:
            accessible += 1
    
    return accessible

def part2(data):
    accessible = 0

    q = deque()
    vis = set()

    for point, neighbors in data.items():
        if len(neighbors) < 4:
            q.appendleft(point)
            vis.add(point)
    
    while q:
        accessible += 1
        point = q.pop()

        for neighbor in data[point]:
            data[neighbor].remove(point)

            if len(data[neighbor]) < 4 and neighbor not in vis:
                q.appendleft(neighbor)
                vis.add(neighbor)
    
    return accessible

if __name__ == "__main__":
    with open("day4/input4.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))