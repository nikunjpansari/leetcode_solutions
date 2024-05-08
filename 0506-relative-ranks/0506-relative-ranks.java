class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        // Define a MAX Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> score[b] -score[a]);

        for(int i=0;i<n;i++)
        {
            pq.add(i);
        }

        int i=1;
        while(!pq.isEmpty())
        {
            int a = pq.poll();
            if(i > 3)
            res[a] = Integer.toString(i);
            else if(i==1)
            res[a] = "Gold Medal";
            else if(i==2)
            res[a] = "Silver Medal";
            else if(i==3)
            res[a] = "Bronze Medal";

            i++;
        }
        return res;
    }
}