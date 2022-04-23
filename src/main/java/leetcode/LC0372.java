package leetcode;

/**
 * @author liubinghui
 * @date 2021/12/5 7:54 下午
 */
public class LC0372 {
    public static void main(String[] args) {
        //System.out.println(91*91*91*91*91%8==superPow(91,new int[]{9}));
        System.out.println(151*151*151*151*151%1337);
        System.out.println((((151*151)%1337*(151*151)%1337)%1337)*151%1337==superPow(151,new int[]{5}));
    }

    public static int superPow(int a, int[] b) {
        int bValue = 0;
        int scale = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            bValue = bValue + b[i] * scale;
            scale = scale * 10;
        }
        return recurse(a,bValue,1337,1);
    }

    public static int recurse(int a, int b,int divisor, int last){
        int remainder = a%divisor;
        if (b == 1){
            return (remainder*last)%divisor;
        }
        if (b%2==0){
            return recurse(remainder*remainder,b/2,divisor,last%divisor);
        }else{
            return recurse(remainder*remainder,b/2,divisor,remainder*last%divisor);
        }
    }
}
