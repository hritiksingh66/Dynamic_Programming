public class Equal_Sum_Partition {
    public static void main(String[] args) {
        int[] arr = {1,5,11,6};
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
        }
        if(sum%2 != 0){
            System.out.println(false);
        }else{
            System.out.println(subsetSum(arr,sum/2,arr.length));
        }
    }
    public static boolean subsetSum(int[] arr,int sum,int n){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0 ; i < n+1 ; i++){
            dp[i][0] = true;
        }
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < sum+1 ; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
