class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        int m =t.length();
        if(n !=m){
            return false;
        }
        int[] m1= new int[256];
        int[] m2= new int[256];
        for (int i=0; i<n; i++){
            char c1= s.charAt(i);
            char c2= t.charAt(i);
            if(m1[c1]==0 && m2[c2]== 0){
                m1[c1] =c2;
                m2[c2]=c1;
            }
            else if(m1[c1] !=c2){
                return false;
            }
        }
        return true;
    }
}