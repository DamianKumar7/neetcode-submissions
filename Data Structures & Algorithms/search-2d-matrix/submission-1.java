class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target > matrix[m - 1][n - 1]) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                // binary search the element here
                int low = 0;
                int high = n - 1;
                while (high >= low) {
                    int mid = (high + low) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] > target) {
                        high = mid - 1;
                    } else if (matrix[i][mid] <= target) {
                        low = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
