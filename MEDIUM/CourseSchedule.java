class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList <LinkedList<Integer>> adj_list = new ArrayList<>();
        for (int a = 0; a < numCourses; a++) {
            adj_list.add(new LinkedList<>());
        }
        
        /*
         * create an adjacency list for the courses 
         */
        for (int rows = 0; rows < prerequisites.length; rows++) {
            int prereq_course = prerequisites[rows][1];
            int course = prerequisites[rows][0];
            
            adj_list.get(prereq_course).add(course);
        }
        
        /*
         * want to apply topological ordering to check if prerequisites work
         */ 
        
        int [] in_count = new int [numCourses];
        
        for (int node = 0; node < adj_list.size(); node++) {
            for (int edges = 0; edges < adj_list.get(node).size(); edges++) {
                in_count[adj_list.get(node).get(edges)]++;
            }
        }
        boolean hasVisited [] = new boolean[numCourses];
        for (int a = 0; a < numCourses; a++) {
            hasVisited[a] = false;    
        }
        
        Queue <Integer> no_incoming_edges = new LinkedList<>();
        for (int i = 0; i < in_count.length; i++) {
            if (in_count[i] == 0) {
                no_incoming_edges.add(i);
                hasVisited[i] = true;
            }
        }
        
        if (no_incoming_edges.isEmpty()) {
            return false;
        }
        
        int counter = 0;
        
        while (!no_incoming_edges.isEmpty()) {
            int curr_node = no_incoming_edges.remove();
            counter++;
            
            for (int node = 0; node < adj_list.get(curr_node).size(); node++) {
                in_count[adj_list.get(curr_node).get(node)]--;
            }
            
            for (int i = 0; i < numCourses; i++) {
                if (in_count[i] == 0 && !hasVisited[i]) {
                    no_incoming_edges.add(i);
                    hasVisited[i] = true;
                }
            }
        }
        
        if (counter != numCourses) {
            return false;
        }
        
        return true;
    }
}
