class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }
        int start =0;
        int maxLength =1;
        for(int i=0; i<s.length(); i++){
            int j=i;
            int len1=expand(s,i,j);
            j=i+1;
            int len2=expand(s,i,j);
            int len=Math.max(len1,len2);
            if(len> maxLength){
                start=i-(len-1)/2;
                maxLength= len;
            }
        }
        return s.substring(start,start+maxLength);
    }
    public int expand(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}