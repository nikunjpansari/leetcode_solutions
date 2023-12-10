class Solution {
    public static List<Integer> getGoodIndices(int[][] var, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < var.length; i++) {
            int ai = var[i][0];
            int bi = var[i][1];
            int ci = var[i][2];
            int mi = var[i][3];

            int result1 = 1;
            for (int j = 0; j < bi; j++) {
                result1 = (result1 * ai) % 10;
            }
            int result2=1;
            for(int j=0;j<ci;j++){
                result2=(result1*result2)%mi;
            }

            if (result2 == target) {
                list.add(i);
            }
        }
        return list;
    }
}