class Solution {
       public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] times = new int[n];
        Arrays.fill(times, Integer.MAX_VALUE);
        Map<Integer, Set<int[]>> map = new HashMap<>();
        for (int[] meeting : meetings) {
        	Set<int[]> set = map.getOrDefault(meeting[0], new HashSet<int[]>());
        	set.add(new int[] {meeting[1], meeting[2]});
        	map.put(meeting[0], set);
        	set = map.getOrDefault(meeting[1], new HashSet<int[]>());
        	set.add(new int[] {meeting[0], meeting[2]});
        	map.put(meeting[1], set);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        q.offer(firstPerson);
        times[0] = times[firstPerson] = 0;
        while (!q.isEmpty()) {
        	int person = q.poll();
        	Set<int[]> set = map.getOrDefault(person, new HashSet<int[]>());
        	for (int[] p : set) 
            {
        		if (times[person] > p[1] || times[p[0]] <= p[1])
        			continue;
    			times[p[0]] = p[1];
    			q.offer(p[0]);
        	}
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
        	if (times[i] != Integer.MAX_VALUE)
        		ans.add(i);
        return ans;
    }
}