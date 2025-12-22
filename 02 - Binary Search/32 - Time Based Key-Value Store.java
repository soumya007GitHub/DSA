class Pair{
    String value;
    int time;
    Pair(String value, int time){
        this.value = value;
        this.time = time;
    }
}
class TimeMap {
    HashMap<String, ArrayList<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<Pair> list = map.get(key);
        int low = 0;
        int high = list.size()-1;
        String answer = "";
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(list.get(mid).time <= timestamp){
                answer = list.get(mid).value;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return answer;
    }
}

// TC - O(logN)
// SC - O(N)