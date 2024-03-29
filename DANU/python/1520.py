import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

m, n = map(int, input().split())
arr = [list(map(int, input().split())) for i in range(m)]
dp = [[-1] * n for i in range(m)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def is_range(x, y, now):
    return 0 <= x < m and 0 <= y < n and arr[x][y] < now

def ans(x, y):
    if x == m - 1 and y == n - 1:
        return 1
    if dp[x][y] == -1:
        dp[x][y] = 0
        for i in range(4):
            dr_x, dr_y = x + dx[i], y + dy[i]
            if is_range(dr_x, dr_y, arr[x][y]):
                dp[x][y] += ans(dr_x, dr_y)

    return dp[x][y]

print(ans(0, 0))
