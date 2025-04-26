import sys

def solution1():
    N = int(input())
    for _ in range(N):
        i = int(input())
        if i + 2 > 100000:
            print(-1)
        else:
            print(i + 2)
            print('y' * 2 + 'c' * i)

def solution2():
    p = []
    for _ in range(4):
        x, y, z = map(int, sys.stdin.readline().split())
        p.append((x, y, z))
    u = (p[1][0] - p[0][0], p[1][1] - p[0][1], p[1][2] - p[0][2])
    v = (p[2][0] - p[0][0], p[2][1] - p[0][1], p[2][2] - p[0][2])
    w = (p[3][0] - p[0][0], p[3][1] - p[0][1], p[3][2] - p[0][2])

    d = (
        u[0] * (v[1] * w[2] - v[2] * w[1]) -
        u[1] * (v[0] * w[2] - v[2] * w[0]) +
        u[2] * (v[0] * w[1] - v[1] * w[0])
    )
    print(f"{abs(d) / 6.0:.14f}")

def solution3():
    for line in sys.stdin:
        x = line.strip()
        print(int(x, 16))