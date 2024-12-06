with open("day6/input.txt", "r") as file:
    grid = [list(line) for line in file.read().strip().splitlines()]

for r in range(len(grid)):
    for c in range(len(grid[r])):
        if grid[r][c] == "^":
            start = (r, c)

dirs = [(-1, 0), (0, 1), (1, 0), (0, -1)]


def outside(row, col, grid):
    return row < 0 or col < 0 or row >= len(grid) or col >= len(grid[0])


def simulate(start, grid):
    dir = 0
    visited = {start}
    path = {(start, dir)}
    row, col = start
    cycle = False

    while True:
        dy, dx = dirs[dir]
        dr, dc = row + dy, col + dx

        if outside(dr, dc, grid):
            break

        if grid[dr][dc] == "#":
            dir = (dir + 1) % 4
        else:
            if ((dr, dc), dir) in path:
                cycle = True
                break
            path.add(((dr, dc), dir))
            visited.add((dr, dc))
            row, col = dr, dc

    return visited, cycle


visited, _ = simulate(start, grid)
map_covered = len(visited)

print("Part 1 Solution:", map_covered)

visited.remove(start)

cycles = 0

for r, c in visited:
    grid[r][c] = "#"
    _, cycle = simulate(start, grid)
    if cycle:
        cycles += 1
    grid[r][c] = "."

print("Part 2 Solution:", cycles)
