class TimeMap {

    public class Pair{
        String value;
        int timestamp;
        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String,List<Pair>>map;

    public TimeMap() {
         map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList()).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair>values = map.get(key);
        if(values == null || values.isEmpty()){
            return "";
        }
        int low = 0;
        int high = values.size()-1;
        String result = "";
        while(low<=high){
            int mid = (low+high)/2;
            if(values.get(mid).timestamp == timestamp){
                return values.get(mid).value;
            }
            else if(timestamp < values.get(mid).timestamp){
                high = mid-1;
            }
            else{
                result = values.get(mid).value;
                low = mid+1;
            }
        }

        return result;
    }
}