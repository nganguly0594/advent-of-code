with open("day2/input.txt", "r") as file:
    lines = [list(map(int, line.split())) for line in file]


def isSafe(line):
    sign = line[1] - line[0]

    for i in range(len(line) - 1):
        diff = line[i + 1] - line[i]
        if diff * sign <= 0 or abs(diff) > 3:
            return False

    return True


safe = 0

for line in lines:
    if isSafe(line):
        safe += 1

print("Part 1 Solution:", safe)

safe = 0

for line in lines:
    if isSafe(line):
        safe += 1
    else:
        for i in range(len(line)):
            if isSafe(line[:i] + line[i + 1 :]):
                safe += 1
                break

print("Part 2 Solution", safe)
