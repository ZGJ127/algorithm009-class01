/**
 * 有效的字母异位词
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int temp : count) {
            if (temp != 0) {
                return false;
            }
        }
        return true;
    }
}

/**
 * 两数和
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i= 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.get(temp) != null) {
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}