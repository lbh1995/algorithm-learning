package leetcode;

/**
 * @author liubinghui
 * @date 2021/11/13 5:04 下午
 */
public class LC0520 {
    public boolean detectCapitalUse(String word) {
        boolean firstUp = word.charAt(0) <= 'Z';
        boolean remainUp = true;
        if (word.length()>=2 && word.charAt(1)>'Z'){
            remainUp = false;
        }
        if (!firstUp && remainUp){
            return false;
        }
        boolean curUp = remainUp;
        for(char c : word.substring(1).toCharArray()){
            curUp = c<='Z';
            if (curUp!=remainUp){
                return false;
            }
        }
        return true;
    }
}
