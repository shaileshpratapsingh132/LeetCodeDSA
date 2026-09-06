class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || s.length() < t.length()){
            return "";
        }
        int[] need=new int[128];
        int[] window =new int[128];
        for(char c: t.toCharArray()){
            need[c]++;
        }
        int required =0;
        for(int i=0; i<128; i++){
            if(need[i]>0){
                required++;
            }
        }
        int formed=0;
        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int minStart=0;
        while(right<s.length()){
            char c=s.charAt(right);
            window[c]++;
            if(need[c]>0 && window[c]==need[c]){
                formed++;

            }
            while(left <=right && formed == required){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    minStart=left;
                }
                char ch=s.charAt(left);
                window[ch]--;
                if(need[ch]> 0 && window[ch] < need[ch]){
                    formed--;
                }
                left++;
            }
            right++;
        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minStart,minStart+minLen);

    }
}