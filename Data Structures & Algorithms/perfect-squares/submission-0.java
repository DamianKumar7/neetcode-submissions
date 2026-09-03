class Solution {
    public int numSquares(int n) {
        List<Integer>input = new ArrayList<>();
        for(int i =1; i*i <=n; i++){
            input.add(i*i);
        }
        //todo convert it to an array;
        int m = input.size();
        int[] arr = new int[m];
        for(int i =0; i <m; i++){
            arr[i] = input.get(i);
        }
        int[][]dp = new int[m+1][n+1];
        dp[0][0] = 0;

        for(int i =0; i <=m; i++){
            for(int j =0; j<=n; j++){
                if(j ==0 && i!= 0){
                    dp[i][j] = 0;
                }
                if(i ==0 && j!= 0){
                    dp[i][j] = Integer.MAX_VALUE-1;
                }
            }
        }

        for(int i =1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-arr[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];

    }
}