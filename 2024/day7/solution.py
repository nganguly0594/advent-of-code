totals = []
all_terms = []

with open("day7/input.txt", "r") as file:
    for line in file.read().splitlines():
        total, terms = line.split(": ")
        totals.append(int(total))
        all_terms.append(list(map(int, terms.split())))


def backtrack1(index, curr_total, total, terms):
    if index == len(terms):
        return curr_total == total

    return backtrack1(index + 1, curr_total + terms[index], total, terms) or backtrack1(
        index + 1, curr_total * terms[index], total, terms
    )


def backtrack2(index, curr_total, total, terms):
    if index == len(terms):
        return curr_total == total

    return (
        backtrack2(index + 1, curr_total + terms[index], total, terms)
        or backtrack2(index + 1, curr_total * terms[index], total, terms)
        or backtrack2(index + 1, int(str(curr_total) + str(terms[index])), total, terms)
    )


calibration1 = 0
calibration2 = 0

for total, terms in zip(totals, all_terms):
    if backtrack1(1, terms[0], total, terms):
        calibration1 += total
    if backtrack2(1, terms[0], total, terms):
        calibration2 += total


print("Part 1 Solution:", calibration1)
print("Part 2 Solution:", calibration2)
