class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if(s1Len > s2Len){
            return false;
        }

        int[] s1Block = new int[26];
        int[] s2Block = new int[26];

        for(int i=0;i<s1Len;i++){
            s1Block[s1.charAt(i)- 'a']++;
            s2Block[s2.charAt(i) - 'a']++;
        }

        if(matches(s1Block,s2Block)){
            return true;
        }

        for(int i=s1Len;i<s2Len;i++){
            s2Block[s2.charAt(i)-'a']++;
            s2Block[s2.charAt(i-s1Len)-'a']--;

            if(matches(s1Block,s2Block)){
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] s1Block, int[] s2Block){
        return Arrays.equals(s1Block,s2Block);
    }
}
