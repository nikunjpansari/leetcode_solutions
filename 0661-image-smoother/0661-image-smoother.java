class Solution {
    public int[][] imageSmoother(int[][] img) {
        int out[][]=new int[img.length][img[0].length];
        int dir[][]=new int[][]{{1,0},{-1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,-1},{-1,1},{0,0}};
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){
               int sum=0,count=0;
               for(int k=0;k<dir.length;k++){
                   int row=i+dir[k][0];
                   int col=j+dir[k][1];
                   if(row >=0 && col >=0 && row< img.length && col<img[0].length){
                       sum+=img[row][col];
                      count++;
                   }
               }
               out[i][j]=(int)Math.floor(sum/count) ;
            }
        }
        return out;
    }
}