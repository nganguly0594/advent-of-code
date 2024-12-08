from collections import defaultdict

with open("day8/input.txt", "r") as file:
    grid = [list(line) for line in file.read().splitlines()]

antennas = defaultdict(list)

m, n = len(grid), len(grid[0])

for r in range(m):
    for c in range(n):
        if grid[r][c] == ".":
            continue

        antennas[grid[r][c]].append((r, c))

antinodes = 0
anodes2 = 0

g2 = [line[:] for line in grid]

for freq, nodes in antennas.items():
    if len(nodes) == 1:
        continue

    for i in range(len(nodes) - 1):
        for j in range(i + 1, len(nodes)):
            r1, c1 = nodes[i]
            r2, c2 = nodes[j]

            dr, dc = r1 - r2, c1 - c2

            if r1 + dr >= 0 and 0 <= c1 + dc < n and grid[r1 + dr][c1 + dc] != "#":
                antinodes += 1
                grid[r1 + dr][c1 + dc] = "#"

            if r2 - dr < m and 0 <= c2 - dc < n and grid[r2 - dr][c2 - dc] != "#":
                antinodes += 1
                grid[r2 - dr][c2 - dc] = "#"

            if g2[r1][c1] != "#":
                anodes2 += 1
                g2[r1][c1] = "#"
            if g2[r2][c2] != "#":
                anodes2 += 1
                g2[r2][c2] = "#"

            while r1 + dr >= 0 and 0 <= c1 + dc < n:
                r1 += dr
                c1 += dc

                if g2[r1][c1] != "#":
                    anodes2 += 1
                    g2[r1][c1] = "#"

            while r2 - dr < m and 0 <= c2 - dc < n:
                r2 -= dr
                c2 -= dc

                if g2[r2][c2] != "#":
                    anodes2 += 1
                    g2[r2][c2] = "#"

print("Part 1 Solution:", antinodes)
print("Part 2 Solution:", anodes2)
