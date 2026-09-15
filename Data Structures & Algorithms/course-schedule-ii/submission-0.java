class Solution {
    Set<Integer> courseSet = new LinkedHashSet<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> adjList = preMap.get(prerequisites[i][0]);
            if (adjList == null) {
                adjList = new ArrayList<>();
                preMap.put(prerequisites[i][0], adjList);
            }
            adjList.add(prerequisites[i][1]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, preMap, i)) return new int[0];
            visited.remove(i);
        }
        int[] order = new int[numCourses];
        int i = 0;
        for (Integer course : courseSet) {
            order[i++] = course;
        }
        return order;
    }
    private boolean dfs(Set<Integer> visited, Map<Integer, List<Integer>> preMap, Integer course) {
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);
        if (preMap.get(course) != null) {
            for (Integer preCourse : preMap.get(course)) {
                if (!(dfs(visited, preMap, preCourse)))
                    return false;
                visited.remove(preCourse);
            }
            preMap.get(course).clear();
        }
        courseSet.add(course);
        return true;
    }
    
}
