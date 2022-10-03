/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {
    // approach 1: HashMap + Binary Search
    private Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    // Time complexity: O(1)
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }

    // Time complexity: O(logN)
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        return findClosetValue(timestamp, list);
    }

    private String findClosetValue(int timestamp, List<Pair> list) {
        // binary search
        // Be careful of the upper bound and middle
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // [1, 2, 3 , 4], mid = 
            int mid = (right + left + 1) / 2;
            if (list.get(mid).ts <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        Pair cloest = list.get(left);
        if (cloest.ts > timestamp) {
            return "";
        }
        return cloest.val;
    }

    // inner class - Pair
    class Pair {
        String val;
        int ts;
        Pair (String value, int timestamp) {
            this.val = value;
            this.ts = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

