public class Count_No_Of_Subset_For_Given_Difference{
    public static void main(String[] args){
        int[] arr ={1,1,2,3};
        int diff = 1;
        int n = arr.length;
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        sum = (diff + sum)/2;
        int[][] dp = new int[n+1][sum+1];

        for(int i = 0; i < n+1;i++){
            dp[i][0] = 1;
        }
        System.out.println(countSubsetEqualToSum(arr,sum,n,dp));
    }

    public static int  countSubsetEqualToSum(int[] arr,int sum,int n,int[][] dp){
        for(int i = 1; i < n+1 ; i++){
            for(int j = 1 ; j < sum + 1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}