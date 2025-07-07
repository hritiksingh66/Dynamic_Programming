/*
  You are given a rod of length 'N' inches and an array 'Prices' of size 'N'.
  The rod of length 'i' has a price of 'Prices[i-1]' rupees. You have to find the maximum price you can get by cutting the rod and selling the pieces.
  As per Code , It is exactly same as Unbounded KnapSack Typical Problem. Only length array , prices array and variable name has changed.
  Even if initialization is same as Unbounded KnapSack.
  It's nothing but just a different way of asking the same question by an interviewer just to check whether we're able to identify the pattern or not.
 */

package KNAPSACK.Unbounded_KnapSack;

public class Rod_Cutting {
  public static void main(String[] args) {
    int prices[] = { 15, 14, 10, 45, 30 };
    int length[] = { 1, 2, 3, 4, 5 };
    int N = 7;
    int len = prices.length;
    int[][] dp = new int[len + 1][N + 1];

    for (int i = 1; i < len + 1; i++) {
      for (int j = 1; j < N + 1; j++) {
        if (length[i - 1] <= j) {
          // Include
          int ans1 = dp[i - 1][j - length[i - 1]] + prices[i - 1];
          // Exclude
          int ans2 = dp[i - 1][j];
          dp[i][j] = Math.max(ans1, ans2);
        } else {
          // Exclude
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    System.out.println(dp[len][N]);
  }
}
