package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC0691 {
//    Set<Character> targetChar = new HashSet<>();
//    List<Set<Character>> remainStickers = new ArrayList<>();
//
//    public int minStickers(String[] stickers, String target) {
//        for (Character c : target.toCharArray()) {
//            targetChar.add(c);
//        }
//        Set<Character> all = new HashSet<>();
//        for (String s : stickers) {
//            Set<Character> eachS = new HashSet<>();
//            for (Character c : s.toCharArray()) {
//                if (targetChar.contains(c)) {
//                    eachS.add(c);
//                    all.add(c);
//                }
//            }
//            if (eachS.size() > 0) {
//                remainStickers.add(eachS);
//            }
//        }
//        if (all.size() < targetChar.size()) {
//            return -1;
//        }
//
//        Set<Integer> init = new HashSet<>();
//        for (int i=0;i<remainStickers.size();i++) {
//            init.add(i);
//        }
//
//        Queue<Pair<Set<Integer>, Set<Character>>> queue = new LinkedList<>();
//        queue.offer(new Pair<>(init, new HashSet<>()));
//
//        while (true) {
//            Pair<Set<Integer>, Set<Character>> peek = queue.poll();
//            for (Integer cur : peek.getKey()) {
//                // 下一次可选择的数据
//                Set<Integer> next2Select = new HashSet<>(peek.getKey());
//                next2Select.remove(cur);
//                // 当前能否满足要求
//                Set<Character> curSet = peek.getValue();
//                curSet.addAll(remainStickers.get(cur));
//                if (curSet.containsAll(targetChar)) {
//                    return remainStickers.size() - next2Select.size();
//                }
//                queue.offer(new Pair<>(next2Select, curSet));
//            }
//        }
//    }

    int N = 20, INF = 50;
    String[] ss;
    String t;
    public int minStickers(String[] stickers, String target) {
        List<String> rs = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (Character c : target.toCharArray()) {
            set.add(c);
        }
        for (String s : stickers) {
            StringBuilder sb = new StringBuilder();
            for (Character c : s.toCharArray()) {
                if (set.contains(c)) {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                rs.add(sb.toString());
            }
        }
        ss = new String[rs.size()];
        for (int i=0;i<rs.size();i++) {
            ss[i] = rs.get(i);
        }
        t = target;
        N = target.length();
        int[] mem = new int[1 << target.length()];
        Arrays.fill(mem, -1);
        int ans = dfs_new(0, mem);
        return ans == INF ? -1 : ans;
    }

    private int dfs_new(int state, int[] mem) {
        if (state == ((1 << N) - 1)) {
            return 0;
        }
        if (mem[state] != -1) {
            return mem[state];
        }
        int ans = INF;
        for (String s : ss) {
            int nstate = state;
            B:
            for (Character c : s.toCharArray()) {
                for (int k = 0; k < N; k++) {
                    if (c == t.charAt(k) && ((nstate >> k) & 1) == 0) {
                        nstate = (nstate | ((1 << k)));
                        continue B;
                    }
                }
            }
            if (nstate != state) {
                ans = Math.min(ans, dfs_new(nstate, mem) + 1);
            }
        }
        return mem[state] = ans;
    }

    public static void main(String[] args) {
        LC0691 lc0691 = new LC0691();
        lc0691.minStickers(new String[]{"with", "example", "science"}, "thehat");
    }
}
