from collections import deque

with open("day9/input.txt", "r") as file:
    line = file.read().strip()

# (mem/free, start_idx, len, id)
memory = deque()

curr_idx = 0
id = 0
mem = 1

for c in line:
    space = int(c)
    memory.append((mem, curr_idx, space, id))
    if mem:
        id += 1
    mem = 1 - mem
    curr_idx += space


def add(curr, end, id):
    s = (end - curr + 1) * (curr + end) * 0.5
    return int(s * id)


checksum = 0

while memory:
    mem, idx, space, id = memory.popleft()

    if mem:
        checksum += add(idx, idx + space - 1, id)
        continue

    if not memory:
        break

    rmem, ridx, rspace, rid = memory.pop()

    if not rmem:
        memory.appendleft((mem, idx, space, id))
        continue

    if space < rspace:
        checksum += add(idx, idx + space - 1, rid)
        memory.append((rmem, ridx, rspace - space, rid))
    elif space > rspace:
        checksum += add(idx, idx + rspace - 1, rid)
        memory.appendleft((mem, idx + rspace, space - rspace, id))
    else:
        checksum += add(idx, idx + space - 1, rid)

print("Part 1 Solution:", checksum)

mem_locs = deque()

curr_idx = 0
id = 0
mem = 1

for c in line:
    space = int(c)
    memory.append((mem, curr_idx, space, id))
    if mem:
        id += 1
    mem = 1 - mem
    curr_idx += space

print("Part 2 Solution:")

# map of space size: list of indices with that space size in ascending order
# when looking for empty with size n, check all empty with size n to max size
# if index of first block comes after index of file, skip, and if file size smaller then add rest of free back into map
