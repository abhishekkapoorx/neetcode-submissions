class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) adj.put(i, new ArrayList<Integer>());

        int[] indeg = new int[numCourses];
        for (int[] prereq: prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            indeg[prereq[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        List<Integer> canTake = new ArrayList<>();

        while (!q.isEmpty()) {
            int top = q.poll();
            canTake.add(top);

            for (int nei: adj.get(top)) {
                indeg[nei]--;
                if (indeg[nei] == 0) q.offer(nei);
            }
        }

        return canTake.size() >= numCourses;


    }
}
