package easy;

/*
* Input: strs = ["flower","flow","flight"]
* Output: "fl"
*
* Input: strs = ["dog","racecar","car"]
* Output: ""
* Explanation: There is no common prefix among the input strings.
*
* */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs){
        StringBuilder commonPrefix = new StringBuilder("");
        int s = getSmallestStringLength(strs);
        int n = strs.length;
        if(n == 1){
            return strs[0];
        }
        for(int i=0; i<s; i++){
            boolean isSame = false;
            for(int j=0; j<n-1; j++){
                if(strs[j].charAt(i) == strs[j+1].charAt(i)){
                    isSame = true;
                }else{
                    isSame = false;
                    break;
                }
            }
            if(isSame){
                commonPrefix.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return commonPrefix.toString();
    }

    public static int getSmallestStringLength(String[] strs){
        int n = strs.length;
        int smallestSize = strs[0].length();
        for(int i=1; i<n; i++){
            if(strs[i].length() < smallestSize){
                smallestSize = strs[i].length();
            }
        }
        return smallestSize;
    }

}
