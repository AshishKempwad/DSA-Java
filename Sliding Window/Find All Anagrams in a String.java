class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int stringLength = s.length();
        int patternLength = p.length();

        if(stringLength < patternLength){
            return res;
        }

        int[] stringBlock = new int[26];
        int[] patternBlock = new int[26];

        for(int i=0;i<patternLength;i++){
            stringBlock[s.charAt(i)-'a']++;
            patternBlock[p.charAt(i)-'a']++;
        }

        if(matches(stringBlock,patternBlock)){
            res.add(0);
        }

        for(int i=patternLength;i<stringLength;i++){
            stringBlock[s.charAt(i)-'a']++;
            stringBlock[s.charAt(i-patternLength)-'a']--;

            if(matches(stringBlock,patternBlock)){
                res.add(i-patternLength+1);
            }
        }

        return res;
    }

    private Boolean matches(int[] stringBlock, int[] patternBlock){
        return Arrays.equals(stringBlock,patternBlock);
    }
}
