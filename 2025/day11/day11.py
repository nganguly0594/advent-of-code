from collections import defaultdict, deque

def parse(data):
    adj_list = defaultdict(list)
    indegree = defaultdict(int)

    for line in data:
        start, neighbors = line.split(': ')
        indegree[start]

        for neighbor in neighbors.split():
            adj_list[start].append(neighbor)
            indegree[neighbor] += 1
    
    indegree['out'] += 1

    return adj_list, indegree

def part1(data):
    adj_list, indegs = data
    indegree = indegs.copy()

    q = deque()

    for node, deg in indegree.items():
        if deg == 0:
            q.appendleft(node)

    while q:
        node = q.pop()

        for neighbor in adj_list[node]:
            indegree[neighbor] -= 1

            if indegree[neighbor] == 0 and neighbor != 'you':
                q.appendleft(neighbor)

    path_counts = defaultdict(int)

    q = deque(['you'])
    path_counts['you'] = 1

    while q:
        node = q.pop()

        for neighbor in adj_list[node]:
            indegree[neighbor] -= 1
            path_counts[neighbor] += path_counts[node]

            if indegree[neighbor] == 0:
                q.appendleft(neighbor)
    
    return path_counts['out']

def part2(data):
    adj_list, indegs = data
    indegree = indegs.copy()

    path_counts = defaultdict(int)

    q = deque(['svr'])
    path_counts['svr'] = 1

    while q:
        node = q.pop()

        for neighbor in adj_list[node]:
            indegree[neighbor] -= 1
            path_counts[neighbor] += path_counts[node]

            if indegree[neighbor] == 0 and neighbor != 'dac' and neighbor != 'fft':
                q.appendleft(neighbor)

    paths_to_first = 0
    other = ''

    if indegree['dac'] == 0:
        paths_to_first = path_counts['dac']
        other = 'fft'

        path_counts = defaultdict(int)
        q = deque(['dac'])
        path_counts['dac'] = paths_to_first
    else:
        paths_to_first = path_counts['fft']
        other = 'dac'

        path_counts = defaultdict(int)
        q = deque(['fft'])
        path_counts['fft'] = paths_to_first

    while q:
        node = q.pop()

        for neighbor in adj_list[node]:
            indegree[neighbor] -= 1
            path_counts[neighbor] += path_counts[node]

            if indegree[neighbor] == 0 and neighbor != other:
                q.appendleft(neighbor)
    
    paths_to_second = path_counts[other]

    path_counts = defaultdict(int)
    q = deque([other])
    path_counts[other] = paths_to_second

    while q:
        node = q.pop()

        for neighbor in adj_list[node]:
            indegree[neighbor] -= 1
            path_counts[neighbor] += path_counts[node]

            if indegree[neighbor] == 0:
                q.appendleft(neighbor)
    
    return path_counts['out']

if __name__ == "__main__":
    with open("day11/input11.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))