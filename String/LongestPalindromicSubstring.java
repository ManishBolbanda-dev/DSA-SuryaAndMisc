public class LongestPalindromicSubstring {	
	public static String longestPalinSubstring(String str) {
		// Write your code here.
        
        int n = str.length();
        String tans="", ans="";
        
        int lb=0, ub=0;
        for(int i=0; i<str.length(); i++){
            lb=i;
            ub=i;
            while(ub+1<n && str.charAt(ub+1)==str.charAt(ub)){
                ub++;
            }
            
            while(lb-1>=0 && ub+1<n && str.charAt(lb-1) == str.charAt(ub+1)){
                lb--;
                ub++;
            }
            tans = str.substring(lb, ub+1);
//             System.out.println("temp ans :: "+tans);
            if(tans.length()>ans.length()){
                ans = tans;
            }
        }
        return ans;
	}
}
