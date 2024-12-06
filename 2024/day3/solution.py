import re

with open("day3/input.txt", "r") as file:
    line = " ".join([l for l in file])

mul = re.compile(r"mul\((\d{1,3}),(\d{1,3})\)")
do = re.compile(r"do\(\)")
dont = re.compile(r"don't\(\)")

parts = re.split(r"(?=mul\(|do\(\)|don't\(\))", line)

enable = True
p1 = 0
p2 = 0

for part in parts:
    if do.match(part):
        enable = True
    elif dont.match(part):
        enable = False
    elif mul.match(part):
        nums = mul.findall(part)[0]
        add = int(nums[0]) * int(nums[1])
        p1 += add
        if enable:
            p2 += add

print("Part 1 Solution:", p1)
print("Part 2 Solution:", p2)
