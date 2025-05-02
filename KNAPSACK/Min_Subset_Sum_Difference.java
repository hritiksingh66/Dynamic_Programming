public class Min_Subset_Sum_Difference{
    public static void main(String[] args){
        int[] arr ={1,2,7};
        int n = arr.length;
        int range = 0;

        for(int num : arr){
            range += num;
        }

        int sum = range/2;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i < n+1;i++){
            dp[i][0] = true;
        }

        subsetSum(arr,sum,n,dp);

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < sum + 1 ; i++){
            if(dp[n][i]){
                ans = Math.min(ans , range - 2 * i);
            }
        }

        System.out.println(ans);
    }

    public static void subsetSum(int[] arr,int sum,int n,boolean[][] dp){
        for(int i = 1; i < n+1 ; i++){
            for(int j = 1 ; j < sum + 1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
}