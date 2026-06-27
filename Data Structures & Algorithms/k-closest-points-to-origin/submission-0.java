class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> arr = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                b[0]*b[0] + b[1]*b[1],
                a[0]*a[0] + a[1]*a[1]
            )
        );
        for(int[]coord: points){
            arr.add(coord);
            if(arr.size()>k){
                arr.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = arr.poll();
        }
        return result;
    }
}
