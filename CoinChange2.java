class Solution {
    public int change(int amount, int[] coins) {
     // 2 decision variables amount & coins hence 2D array
     
    // TC: O(mn) SC: O(mn)    
        
     if(coins.length == 0 && amount != 0)
         return 0;
        
    int dp[][] = new int[coins.length + 1][amount + 1];
        
   //Using coin of value 0 we'll not be able to form any amount         
   //Fill the 0th column of every row with 1 as there is exactly one way to make amount 0 with a given coin. Is by not  choosing it
    for(int k=0; k< dp.length; k++) {
        dp[k][0] = 1;
    }    
    
    //For each coin we have 2 options choose or not choose.
    // At the end we have to add both options as the both can make desired amount
        
    for(int i = 1; i < dp.length; i++) {
        for(int j = 1; j < dp[0].length; j++) {
            //If the coin is greater than amount we cannot choose it.
            if(coins[i-1] > j) {
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
            
            
        }
    }
        return dp[dp.length - 1][dp[0].length - 1];
        
    }
}
