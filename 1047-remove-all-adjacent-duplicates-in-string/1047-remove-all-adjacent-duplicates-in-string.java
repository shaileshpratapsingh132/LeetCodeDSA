class Solution {
    public String removeDuplicates(String s) {
       String ans ="";
       int index =0;
       while (index < s.length()){
        if(ans.length() > 0 && ans.charAt(ans.length()-1)== s.charAt(index)){
            ans = ans.substring(0, ans.length()-1);
        }
        else{
            ans =ans+s.charAt(index);
        }
        index++;
       } 
       return ans;
    }
}