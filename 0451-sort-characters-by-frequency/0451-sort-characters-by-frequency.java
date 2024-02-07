class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();

        StringBuilder res = new StringBuilder();

        for(char c :  s.toCharArray())
        {
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)-> Integer.compare(mp.get(b),mp.get(a)));

        for(char ch : mp.keySet())
        {
            pq.add(ch);
        }

        while(pq.size() > 0)
        {
            char ch = pq.remove();
            int f = mp.get(ch);
            while(f > 0 )
            {
            res.append(ch);
            f--;
            }
        }
        return res.toString();
    }
}