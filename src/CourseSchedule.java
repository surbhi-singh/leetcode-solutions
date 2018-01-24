class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        else {
            List<Set<Integer>> prereqs = new ArrayList<Set<Integer>>();
            for(int i=0; i<numCourses; i++) {
                Set<Integer> set = new HashSet<>();
                prereqs.add(i, set);
            }
            for(int i=0; i<prerequisites.length; i++) {
                if(prerequisites[i][0] == prerequisites[i][1]) return false;
                Set<Integer> tempset = prereqs.get(prerequisites[i][0]);
                tempset.add(prerequisites[i][1]);
                if(prerequisites[i][1] < numCourses) {
                    Set<Integer> prereqset = prereqs.get(prerequisites[i][1]);
                    if(!prereqset.isEmpty()) {
                        Queue<Integer> queue = new LinkedList<>();
                        for(Integer prereq : prereqset) queue.offer(prereq);
                        while(!queue.isEmpty()) {
                            Integer val = queue.poll();
                            if(val == prerequisites[i][0]) return false;
                            Set<Integer> t = prereqs.get(val);
                            for(Integer in : t) queue.offer(in);
                        }
                    }
                }
            }
            return true;
        }
    }
}
