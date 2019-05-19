package leetcode.array;

import java.util.Stack;

public class MaxAreaOfIsland {
    static class Point {

        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    //自己想的方法，时间很长估计是栈的来回存储时间长，而且point可以用int数组代替，不用弄的类
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        //用来存储是否遍历过该位置用i*10+j来确定位置
        int[][] flag = new int[grid.length][grid[0].length];
        //存储要遍历的位置
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //未访问过该位置
                if (flag[i][j] == 0 && grid[i][j] == 1) {
                    int count = 1;
                    flag[i][j] = 1;
                    stack.push(new Point(i, j - 1));
                    stack.push(new Point(i + 1, j));
                    stack.push(new Point(i, j + 1));
                    stack.push(new Point(i - 1, j));
                    while (!stack.empty()) {
                        int x = stack.peek().i;
                        int y = stack.peek().j;
                        stack.pop();
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                                && flag[x][y] == 0 && grid[x][y] == 1) {
                            flag[x][y] = 1;
                            count++;
                            stack.push(new Point(x, y - 1));
                            stack.push(new Point(x + 1, y));
                            stack.push(new Point(x, y + 1));
                            stack.push(new Point(x - 1, y));
                        }
                    }
                    max = max < count ? count : max;

                }
            }
        }
        return max;
    }

    //region 迭代法
    int[][] grid;
    boolean[][] flag;

    public int area(int r, int c) {
        if (r < 0 || r > grid.length || c < 0 || c > grid[0].length || flag[r][c] || grid[r][c] == 0)
            return 0;
        flag[r][c] = true;
        //1是当前位置
        return 1 + area(r, c - 1) + area(r + 1, c) + area(r, c + 1) + area(r - 1, c);
    }

    public int maxAreaOfIsland1(int[][] grid) {
        this.grid = grid;
        flag = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
    //endregion

    //改进版循环方法
    public int maxAreaOfIsland2(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int ans = 0;
        for (int r0 = 0; r0 < grid.length; r0++) {
            for (int c0 = 0; c0 < grid[0].length; c0++) {
                if (grid[r0][c0] == 1 && !seen[r0][c0]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[]{r0, c0});
                    seen[r0][c0] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int r = node[0], c = node[1];
                        shape++;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < grid.length &&
                                    0 <= nc && nc < grid[0].length &&
                                    grid[nr][nc] == 1 && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }

}
