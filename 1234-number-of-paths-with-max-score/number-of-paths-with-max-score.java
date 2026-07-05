class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size(), dpVal[] = new int[n+1], dpPath[] = new int[n+1], mod = (int)1e9+7;
        for(int j = n-1; j >= 0; --j){
            var r = board.get(j);
            var diag = new int[2];
            for(int i = n-1; i >= 0; --i){
                var c = r.charAt(i);
                if (c == 'S'){
                    dpPath[n-1] = 1;
                    continue;
                }
                c = c == 'E' ? '0' : c;
                var nDiag = new int[]{dpVal[i],dpPath[i]};
                dpVal[i] = dpPath[i] = 0;
                if (c != 'X'){ 
                    for(var d : new int[][]{new int[]{dpVal[i+1],dpPath[i+1]},nDiag,diag}){
                        if (d[1] == 0) continue;
                        int v = (c-'0')+d[0];
                        if (v > dpVal[i]){
                            dpVal[i] = v;
                            dpPath[i] = d[1];
                        } else if (v == dpVal[i]){
                            long paths = ((long)dpPath[i]+(long)d[1])%mod;
                            dpPath[i] = (int)paths;
                        }
                    }
                }
                diag = nDiag;
            }
        }
        return new int[]{dpVal[0],dpPath[0]};
    }
}