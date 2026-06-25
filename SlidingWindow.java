// Longest Substring Without Repeating Characters
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int max = 0, left = 0;
    for (int right = 0; right < s.length(); right++) {
        if (map.containsKey(s.charAt(right)))
            left = Math.max(left, map.get(s.charAt(right)) + 1);
        map.put(s.charAt(right), right);
        max = Math.max(max, right - left + 1);
    }
    return max;
}
