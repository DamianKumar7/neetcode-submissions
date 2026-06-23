class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[low]<= arr[mid]){
                //the left half is sorted
                if(target>= arr[low] && target<= arr[mid]){
                    high = mid-1;//only search in the left side . eliminate the right side
                }else{
                    low = mid+1; //eliminate yourself
                }
            }
            else if(arr[high]> arr[mid]){
                //the right side is sorted
                if(target>=arr[mid] && target <= arr[high]){
                    low = mid+1; //search only on the right side
                }else{
                    high = mid-1;//eliminate yourself
                }
            }
        }
        return -1;
        
    }
}
