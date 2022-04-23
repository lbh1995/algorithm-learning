package leetcode;

import java.util.*;

/**
 * @author liubinghui
 * @date 2021/7/3 4:17 下午
 */
public class LC0013 {
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>(){
            {
                put("I",1);
                put("V",5);
                put("X",10);
                put("L",50);
                put("C",100);
                put("D",500);
                put("M",1000);
            }
        };
        Set<String> set = new HashSet<String>();
        set.add("I");
        set.add("X");
        set.add("C");

        int res = 0;
        for (int i=0;i<s.length();i++){
            String cur = s.substring(i,i+1);
            if (set.contains(cur) && i+1<s.length()){
                String nxt = s.substring(i+1,i+2);
                if (map.get(nxt)>map.get(cur)){
                    res += map.get(nxt)-map.get(cur);
                    i++;
                    continue;
                }
            }
            res += map.get(cur);
        }
        return res;
    }
}
