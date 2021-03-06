import java.util.PriorityQueue;

//Trapping Rain Water II
public class P407 {
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;

        public Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }

        public int compareTo(Cell other) {
            if (this.height == other.height)
                return 0;
            if (this.height < other.height)
                return -1;
            return 1;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length < 1)
            return 0;
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        int res = 0;
        while (!pq.isEmpty()) {
            Cell t = pq.poll();
            int row = t.row;
            int col = t.col;
            int h = t.height;

            for (int[] d : dirs) {
                int r = d[0] + row;
                int c = d[1] + col;
                if (r > 0 && r < m - 1 && c > 0 && c < n - 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    res += Math.max(0, h - heightMap[r][c]);
                    pq.offer(new Cell(r, c, Math.max(h, heightMap[r][c])));
                }
            }
        }
        return res;
    }
}