class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>list = new ArrayList<>();
        for(int[] i : intervals){
            list.add(i);
        }
        list.add(newInterval);
        Collections.sort(list, (a,b)-> a[0]-b[0]);
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        List<int[]> res = new ArrayList<>();
        for(int i =1 ; i < list.size(); i++){
            if(end>=list.get(i)[0]){
                end = Math.max(end, list.get(i)[1]);
            }else{
                res.add(new int[]{start,end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(int[][]::new);
    }
}
