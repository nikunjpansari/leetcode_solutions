class Solution {
    public int minScore(int n, int[][] roads) {  
        Arrays.sort(roads, (a, b)->{
            return a[0] - b[0];
        });
        HashSet<Integer> set = new HashSet<>();
        set.add(roads[0][0]);
        set.add(roads[0][1]);
        int min = roads[0][2];
        for(int j = 0; j < 100; j++){
            for(int i = 1; i < roads.length; i++){
            if(set.contains(roads[i][0]) || set.contains(roads[i][1])){
                min = Math.min(roads[i][2], min);
                set.add(roads[i][0]);
                set.add(roads[i][1]);
            }
        }
        }        
        return min;
    }
}