class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean res = false;
        Set<Integer> hs = new HashSet<>();
        for(int i : arr)
        {
            
            if(hs.contains(2*i) || i % 2 == 0 && hs.contains(i/2))
            res = true;
            hs.add(i);
        }
        return res;
    }
}