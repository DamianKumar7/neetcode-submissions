class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int high = -1;
        int low = -1;
        int index =0;
        for (int i = 0; i < matrix.length; i++){
            if(target>= matrix[i][0] && target <= matrix[i][matrix[0].length-1]){
                high = matrix[0].length-1;
                low = 0; 
                index = i;
            }
        }
        if(high == -1 || low == -1){
            return false;
        }

        while(low <= high){
            int mid = high-low/2;

            if(matrix[index][mid] == target){
                return true;
            }

            else if(matrix[index][mid]> target){
                high = mid-1;
            }
            else if (matrix[index][mid]<target){
                low = mid+1;
            }
            
        }
        return false;
    }
}
