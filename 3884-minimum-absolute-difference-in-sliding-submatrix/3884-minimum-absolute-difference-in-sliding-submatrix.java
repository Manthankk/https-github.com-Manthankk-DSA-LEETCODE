class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int row = m - k + 1;
        int col = n - k + 1;
        int[][] ans = new int[row][col];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            map.clear();
            for (int newr = i; newr < i + k; newr++) {
                for (int newc = 0; newc < k; newc++) {
                    int val = grid[newr][newc];
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
            }
            ans[i][0] = findMinDiff(map);
            for (int j = 1; j < col; j++) {
                for (int newr = i; newr < i + k; newr++) {
                    int val = grid[newr][j - 1];
                    map.put(val, map.get(val) - 1);
                    if (map.get(val) == 0) {
                        map.remove(val);
                    }
                }
                for (int newr = i; newr < i + k; newr++) {
                    int val = grid[newr][j + k - 1];
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
                ans[i][j] = findMinDiff(map);
            }
        }
        return ans;
    }
    private int findMinDiff(HashMap<Integer, Integer> maps) {
        if (maps.size() == 1) return 0;
        int minDiff = Integer.MAX_VALUE;
        List<Integer> key = new ArrayList<>(maps.keySet());
        Collections.sort(key);  
        for (int i =1; i < key.size();i++) {
            minDiff = Math.min(minDiff, key.get(i)- key.get(i - 1));
        }
        return minDiff;
    }
}