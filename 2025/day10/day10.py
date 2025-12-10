import re
from collections import deque
from scipy.optimize import linprog
import numpy as np

def parse(data):
    end_states = []
    button_lists = []
    joltages = []

    for line in data:
        removed = re.sub(r'[\[\]\(\)\{\}]', '', line)
        parts = removed.split()

        end_states.append(tuple(1 if c == '#' else 0 for c in parts[0]))
        button_lists.append([list(map(int, button.split(','))) for button in parts[1:-1]])
        joltages.append(tuple(map(int, parts[-1].split(','))))
    
    return end_states, button_lists, joltages

def part1(data):
    end_states, button_lists, _ = data

    min_total_steps = 0

    for end, buttons in zip(end_states, button_lists):
        start = (0,) * len(end)
        vis = set()
        q = deque([start])

        steps = -1
        found = False

        while not found:
            steps += 1

            for _ in range(len(q)):
                state = q.pop()

                if state in vis:
                    continue

                if state == end:
                    found = True
                    break

                vis.add(state)
                    
                for button in buttons:
                    next_state = list(state)

                    for idx in button:
                        next_state[idx] ^= 1
                    
                    q.appendleft(tuple(next_state))
        
        min_total_steps += steps

    return min_total_steps

def part2(data):
    _, button_lists, joltages = data

    min_total_steps = 0

    for targets, buttons in zip(joltages, button_lists):
        rows = len(targets)
        cols = len(buttons)

        A = np.zeros((rows, cols), dtype=int)
        for c, button in enumerate(buttons):
            for r in button:
                A[r, c] = 1

        res = linprog(
            c=np.ones(cols),
            A_eq=A,
            b_eq=np.array(targets),
            integrality=True
        )

        steps = int(res.fun)
        min_total_steps += steps

    return min_total_steps

if __name__ == "__main__":
    with open("day10/input10.txt") as f:
        data = f.read().splitlines()
    
    data = parse(data)
    print(part1(data))
    print(part2(data))