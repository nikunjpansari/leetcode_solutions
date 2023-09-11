class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> mp = new HashMap();
        List<List<Integer>> res = new ArrayList<>();

        for(int i =0;i<groupSizes.length;i++)
        {
            int person = i; 
            int g = groupSizes[i];

            List<Integer> ls = mp.getOrDefault(g,new ArrayList());
            ls.add(person);
            mp.put(g,ls);

            if(ls.size()== g)
            {
                res.add(ls);
                mp.remove(g);
            }
        }
        return res;
    }
}