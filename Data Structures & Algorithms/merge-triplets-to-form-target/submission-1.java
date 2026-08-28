class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
      Set<Integer> set = new HashSet<>();
      boolean first = false;
      boolean second = false;
      boolean third = false;
      for(int i =0; i <triplets.length; i++){
        int[]triplet = triplets[i];
        if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<= target[2]){
            set.add(i);
        }
      }
      int count = 0;
      for(int idx: set){
        int[] trip = triplets[idx];
        if(trip[0] == target[0] )first = true;
        if(trip[1] == target[1])second = true;
        if(trip[2] == target[2])third = true;
      }

      return first && second && third;
    }
}
