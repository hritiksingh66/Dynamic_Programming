public class Unbounded_KnapSack {
    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int N = val.length;
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    // Include
                    int ans1 = dp[i - 1][j - wt[i - 1]] + val[i - 1];
                    // Exclude
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    // Exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][W]);
    }
}