package LeetCode;
import java.util.*;

public class TestingClass {
    
    public static void main(final String[] args) {
        TestingClass sol = new TestingClass();
        //int[] tab = {3,3,3,1,2,1,1,2,3,3,4};
        int[] tab = {1,0,1,4,1,4,1,2,3};

        sol.rotatedDigits(10);

        sol.totalFruit(tab);


    }

    public int rotatedDigits(int N) {
        int cnt = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put('2', '5');
        map.put('5', '2');
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for (int i = 1; i <= N; i++) {
            String str = String.valueOf(i);
            if (str.contains("3") || str.contains("4") || str.contains("7")) {
                continue;
            } 
            String newStr = "";
            for (Character c : str.toCharArray()) {
                Character newC = map.get(c);
                newStr += c;
            }
            if (!newStr.contentEquals(str)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < tree.length; i++) {
            int val = tree[i];
            if (map.size() == 2 && !map.containsKey(val)) {
                int toRemove = q.peek();
                while (map.containsKey(toRemove)) {
                    int elem = q.poll();  
                    map.put(elem, map.get(elem)-1);
                    if (map.get(elem) == 0) {
                        map.remove(elem);
                    }
                }
                map.put(val, 1);
                q.offer(val);
                
            } else {
                if (map.containsKey(val)) {
                    map.put(val, map.get(val)+1);
                } else {
                    map.put(val, 1);
                }
                q.offer(val);
            }
            max = Math.max(max, q.size());
        }
        return max;
    }

}