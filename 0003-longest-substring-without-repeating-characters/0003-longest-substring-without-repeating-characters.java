class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int left=0;
        int maxl=0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxl=Math.max(maxl,right-left+1);
        }
return maxl;
    }
}