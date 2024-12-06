with open("day4/input.txt", "r") as file:
    grid = [list(line.strip()) for line in file]

dirs = [(0, 1), (1, 0), (0, -1), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
dirpairs = [((1, 1), (-1, -1)), ((1, -1), (-1, 1))]

xmas = 0
mas = "MAS"
x_mas = 0


def out(r, c):
    return r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0])


for r in range(len(grid)):
    for c in range(len(grid[r])):
        if grid[r][c] == "X":
            for dy, dx in dirs:
                dr, dc = r, c

                for i in range(3):
                    dr, dc = dr + dy, dc + dx

                    if out(dr, dc) or grid[dr][dc] != mas[i]:
                        break

                    if i == 2:
                        xmas += 1

        elif grid[r][c] == "A":
            mas_count = 0

            for (dx, dy), (ddx, ddy) in dirpairs:
                dr, dc, ddr, ddc = r + dy, c + dx, r + ddy, c + ddx

                if out(dr, dc) or out(ddr, ddc):
                    continue

                if (
                    grid[dr][dc] in "MS"
                    and grid[ddr][ddc] in "MS"
                    and grid[dr][dc] != grid[ddr][ddc]
                ):
                    mas_count += 1

                if mas_count == 2:
                    x_mas += 1
                    break

print("Part 1 Solution:", xmas)
print("Part 2 Solution:", x_mas)
