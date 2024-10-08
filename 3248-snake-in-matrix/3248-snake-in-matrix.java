class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x=0, y=0;
        for(String str:commands){
            if(str.equals("RIGHT") && x+1<n){
                x++;
            }
            else if(str.equals("LEFT") && x>0){
                x--;
            }
            else if(str.equals("DOWN") && y+1<n){
                y++;
            }
            else if(y>0 && str.equals("UP")){
                y--;
            }
        }
        return (y*n)+x;
    }
}