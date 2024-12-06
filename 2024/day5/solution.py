from collections import defaultdict, deque

with open("day5/input.txt", "r") as file:
    parts = file.read().strip().split("\n\n")
    rules = [tuple(map(int, line.split("|"))) for line in parts[0].splitlines()]
    updates = [list(map(int, line.split(","))) for line in parts[1].splitlines()]


def valid(update):
    specific_rules = [(x, y) for x, y in rules if x in update and y in update]

    for x, y in specific_rules:
        if update.index(x) > update.index(y):
            return False
    return True


def fix(update):
    specific_rules = [(x, y) for x, y in rules if x in update and y in update]

    adj = defaultdict(list)
    indegree = {page: 0 for page in update}

    for x, y in specific_rules:
        adj[x].append(y)
        indegree[y] += 1

    q = deque()

    for key in indegree:
        if indegree[key] == 0:
            q.append(key)

    sort = []

    while q:
        v = q.popleft()
        sort.append(v)

        for n in adj[v]:
            indegree[n] -= 1
            if indegree[n] == 0:
                q.append(n)

    return sort


mid_sum_correct = 0
mid_sum_incorrect = 0

for update in updates:
    if valid(update):
        mid_sum_correct += update[len(update) // 2]
    else:
        changed = fix(update)
        mid_sum_incorrect += changed[len(changed) // 2]


print("Part 1 Solution:", mid_sum_correct)
print("Part 2 Solution:", mid_sum_incorrect)
