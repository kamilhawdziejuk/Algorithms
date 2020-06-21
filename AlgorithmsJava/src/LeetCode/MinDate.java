package LeetCode;
import java.util.*;

public class MinDate {
    public static void main(final String[] args) {
        final MinDate sol = new MinDate();
        
       //sol.multiply("9133", "0");
        int res = sol.numTilePossibilities("AAB");
        if (res > 0) {

        }
    }

    Set<String> set = new HashSet<>();
    
    public int numTilePossibilities(String tiles) {
        gen(tiles, new ArrayList<>(), 0);
        return set.size();
    }
    
    private void gen(String tiles, List<Integer> used, int level) {
        int n = tiles.length();
        if (level == n) {
            String str = hash(used, tiles);
            if (!set.contains(str)) {
                set.add(str);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used.contains(i)) {
                continue;
            }
            List<Integer> toUse = new ArrayList<>(used);
            toUse.add(i);
            gen(tiles, toUse, level+1);
        }
        gen(tiles, used, level+1);
    }
    
        private String hash(List<Integer> list, String tiles) {
            String str = "";
            for (Integer d : list) {
                Character c = tiles.charAt(d);
                str += c;
            }
            return str;
        }

    public String multiply(String num1, String num2) {
        List<Integer> list1 = getDigits(num1);
        List<Integer> list2 = getDigits(num2);
        List<Integer> prev = null;
        int move = 0;
        for (int i = list1.size()-1; i >= 0; i--) {
            int val = list1.get(i);
            List<Integer> res = mult(list2, val);
            if (prev == null) {
                prev = res;
            } else {
                List<Integer> tmp = add(res, prev, move);
                prev = tmp;
            }   
            move++;
        }

        String result = "";
        for (int i = 0; i < prev.size(); i++) {
            result = result + prev.get(i);
        }
        String end = "";
        for (int i = 0; i < result.length(); i++) {
            if (end.isEmpty()) {
                if (result.charAt(i)!='0') {
                    end += result.charAt(i);
                }
            } else {
                end += result.charAt(i);
            }
        }
        if (end.isEmpty()) {
            end = "0";
        }
        return end;
    }
    
    private List<Integer> mult(List<Integer> list, int val) {
        List<Integer> res = new ArrayList<>();
        int next = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            int data = list.get(i);
            int cur = val * data;
            cur += next;
            if (cur > 9) {
                next = cur / 10;
                cur = cur - next*10;
                res.add(0, cur);
            } else {
                res.add(0, cur);
                next = 0;
            }
        }
        if (next > 0) {
            res.add(0, next);
        }
        return res;
    }
    
    //list2 na gorze
    private List<Integer> add(List<Integer> list1, List<Integer> list2, int move) {
        List<Integer> res = new ArrayList<>();
        int next = 0;
        int i = list2.size()-1;
        int j = list1.size()-1+move;
        
        while (i >= 0 || j>= 0) {
            int data2 = 0; 
            if (i >= 0 && i < list2.size()) {
                data2 = list2.get(i);
            }
            int data1 = 0;
            if (j >= 0 && j < list1.size()) {
                data1 = list1.get(j);
            }
            int cur = data1 + data2;
            cur += next;
            if (cur > 9) {
                next = cur / 10;
                cur = cur - next*10;
                res.add(0, cur);
            } else {
                res.add(0, cur);
                next = 0;
            }
            i--;
            j--;
        }
        if (next > 0) {
            res.add(0, next);
        }
        return res;
    }

    private List<Integer> getDigits(final String num) {
        final List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            final Character c = num.charAt(i);
            final Integer val = Integer.valueOf(c+"");
            digits.add(val);
        }
        return digits;
    }

    public List<String> findMissingRanges(final int[] nums, final int lower, final int upper) {
        final int n = nums.length;
        final List<String> res = new ArrayList<>();
        if (n == 0) {
            if (lower == upper) {
                res.add(lower+"");
            } else {
                res.add(lower+"->"+upper);
            }
            return res;
        }
        if (lower < nums[0]) {
            res.add(getRange(lower, nums[0]-1));
        }
        for (int i = 0; i < n-1; i++) {
            if (nums[i] < Integer.MAX_VALUE && nums[i] +1 < nums[i+1]) {
                res.add(getRange(nums[i]+1, nums[i+1]-1));
            }
        }
        if (upper > nums[n-1]) {
            res.add(getRange(nums[n-1]+1, upper));
        }
        return res;
    }
    
    private String getRange(final int from, final int to) {
        if (from == to) {
            return from+"";
        } else {
            return from + "->" + to;
        }
    }

    class IncComparator implements Comparator<Integer>
	{
	    @Override
	    public int compare(final Integer x, final Integer y)
	    {
	        if (x == y) return 0;
	        if (x < y) return -1;
	        return 1;
	    }
	}
    
    public int kEmptySlots(final int[] bulbs, final int K) {
        final int n = bulbs.length;
        final Queue<Integer> que = new PriorityQueue<>(new IncComparator());
        for (int i = 0; i < n; i++) {
            que.offer(bulbs[i]);
            
            if (check(que, K)) {
                return i+1;
            }
        }
        return -1;
    }
    
    private boolean check(final Queue<Integer> que, final int K) {
        Integer prev = null;
        
        for (final Integer item : que) {
            if (prev == null)  {
                prev = item;
            } else {
                if (item - prev == (K+1)) {
                    return true;
                }
                prev = item;
            }
        }
        return false;
    }

    public boolean isStrobogrammatic(final String num) {
        final int n = num.length();
        if (n == 1) {
            final Character c = num.charAt(0);
            if (c == '8' || c == '0' || c == '1')
            {
                return true;
            }
            return false;
        }
        for (int i = 0; i < n/2; i++) {
            final Character c1 = num.charAt(i);
            final Character c2 = num.charAt(n-i-1);
            
            if (c1 == '6' && c2 == '9' || c1 == '9' && c2 == '6' || c1 == '8' && c2 == '8' || c1 == '0' && c2 == '0' || c1 == '1' && c2 == '1') {
                continue;
            } else {
                return false;
            }
        }
        if (n%2==1){
            final int k = n/2+1;
            final Character c = num.charAt(k);
            return (c == '8' || c == '0' || c == '1');
        }
        return true;
    }


    class Position {
        public int Row;
        public int Col;
        
        public Position(final int row, final int col) {
            Row = row;
            Col = col;
        }
        
        public List<Position> getNext() {
            final List<Position> list = new ArrayList<>();
            list.add(new Position(Row+1, Col+2));
            list.add(new Position(Row-1, Col+2));
            list.add(new Position(Row+1, Col-2));
            list.add(new Position(Row-1, Col-2));
            list.add(new Position(Row+2, Col+1));
            list.add(new Position(Row+2, Col-1));
            list.add(new Position(Row-2, Col+1));
            list.add(new Position(Row-2, Col-1));
            return list;
        }
        
        public boolean isInside(final int n) {
            return Row < n && Col < n && Row >=0 && Col >= 0;
        }
    }
    
    private double found = 0;
    
    private void dfs(final Position pos, final int nr, final int K, final int N) {
        if (nr > K) return;
        
        if (pos.isInside(N)) {
            found++;
        }
        if (nr < K) {
            final List<Position> nexts = pos.getNext();
            for (final Position p : nexts) {
                dfs(p, nr+1, K, N);
            }    
        }
    }
    
    public double knightProbability(final int N, final int K, final int r, final int c) {
        final Position pos = new Position(r, c);
        final List<Position> nexts = pos.getNext();
        for (final Position p : nexts) {
            dfs(p, 1, K, N);
        }
        
        double amount = 1;
        for (int i = 1; i<= K; i++) {
            amount *= 8;
        }
        return found / amount;
    }




    class Bloom implements Comparable<Bloom> {
        public int left;
        public int right;
        public int dayNr;
        public int pos;
        public int Cnt;

        @Override
			public int compareTo(final Bloom arg0) { //needed for map.containsKey
				if (dayNr == arg0.dayNr) {
					return 0;
                }
                if (dayNr < arg0.dayNr) {
                    return -1;
                }
				return 1;
			}
    }

    public int minDays(final int[] bloomDay, final int m, final int k) {
        //buckets = m
        //flowers = k
        final int n = bloomDay.length;
        final List<Bloom> blooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final Bloom bl = new Bloom();
            bl.dayNr = bloomDay[i];
            bl.pos = i;
            blooms.add(bl);
        }

        Collections.sort(blooms);
        final Bloom[] tab = new Bloom[n];

        for (int i = 0; i < n; i++) {
            final Bloom bloom = blooms.get(i);
            final int nr = bloom.pos;

            if (tab[nr] == null) {
                tab[nr] = bloom;
                int left = 0;
                int right = 0;
                tab[nr].Cnt = 1;

                if (nr > 0 && tab[nr-1] != null) {
                    tab[nr].left = tab[nr-1].left+1;
                    left = tab[nr].left;
                }

                if (nr < n-1 && tab[nr+1] != null) {
                    tab[nr].right = tab[nr+1].right+1;
                    right = tab[nr].right;
                }

                if (right > 0) {
                    tab[nr+right].left += left;

                    tab[nr+right].Cnt = -1;
                    tab[nr+1].Cnt = -1;
                    tab[nr].Cnt = tab[nr].right+1;
                }

                if (left > 0) {
                    tab[nr- left].right = left;

                    tab[nr-1].Cnt = -1;
                    tab[nr].Cnt = -1;
                    tab[nr -left].Cnt = left+1;
                }

                
            }
        }
        return 0;
    }
}