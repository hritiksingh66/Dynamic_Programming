public class _0_1_KnapSack_Memoized {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int N = val.length;
        int[][] dp = new int[N+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapMemo(val,wt,W,N,dp));
    }

    public static int knapMemo(int[] val , int[] wt,int W,int N , int[][] dp){
        // Base Condition
        if(N==0 || W==0){
            return 0;
        }
        if(dp[N][W] != -1){
            return dp[N][W];
        }

         // Choice Diagram
         if(wt[N-1] <= W){ // If weight of the item is less than the capacity of the bag
            //Include 
            int ans1 = knapMemo(val,wt,W-wt[N-1],N-1,dp) + val[N-1];
            //Exclude
            int ans2 = knapMemo(val,wt,W,N-1,dp);
            return dp[N][W] = Math.max(ans1,ans2);
        }else if(wt[N-1] > W){ // If weight of the item is greater than the capacity of the bag
            return dp[N][W] = knapMemo(val,wt,W,N-1,dp);
        }
        return 0;
    }
}
