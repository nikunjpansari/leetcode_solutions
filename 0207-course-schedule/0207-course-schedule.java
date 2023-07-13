// Time Complexity :O(N)
// Space Complexity :O(N)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
        adj.add(new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
        adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    int indegree[] = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
        for (int it : adj.get(i)) {
            indegree[it]++;
        }
    }

    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
            q.add(i);
        }
    }

    int count = 0;
    while (!q.isEmpty()) {
        int node = q.poll();
        count++;

        for (int it : adj.get(node)) {
            indegree[it]--;
            if (indegree[it] == 0) {
                q.add(it);
            }
        }
    }

    return count == numCourses;
}

}