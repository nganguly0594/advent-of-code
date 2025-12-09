from collections import Counter

with open("day1/input.txt", "r") as file:
    lines = [line.strip() for line in file]

list1 = []
list2 = []

for line in lines:
    parts = line.split("   ")
    list1.append(int(parts[0]))
    list2.append(int(parts[1]))

list1.sort()
list2.sort()

sumDist = 0

for one, two in zip(list1, list2):
    sumDist += abs(one - two)

print("Part 1 Solution:", sumDist)

similarity = 0

count1 = Counter(list1)
count2 = Counter(list2)

for key, val in count1.items():
    if key in count2:
        similarity += val * key * count2[key]

print("Part 2 Solution: ", similarity)
