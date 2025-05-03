public class _0_1_KnapSack_Recursive {
    public static int knapsack(int val[],int wt[],int W,int N){
        // Base Condition - Always check for Smallest valid Input
        if(N==0 || W==0){ // N==0 --> No items there in the store || W == 0 --> No capacity to store any items
            return 0;
        }

        // Choice Diagram
        if(wt[N-1] <= W){ // If weight of the item is less than the capacity of the bag
            //Include 
            int ans1 = knapsack(val,wt,W-wt[N-1],N-1) + val[N-1];
            //Exclude
            int ans2 = knapsack(val,wt,W,N-1);
            return Math.max(ans1,ans2);
        }else if(wt[N-1] > W){ // If weight of the item is greater than the capacity of the bag
            return knapsack(val,wt,W,N-1);
        }
        return 0;
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int N = val.length;
        System.out.println(knapsack(val,wt,W,N));
    }
}