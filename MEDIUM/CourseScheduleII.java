class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // declare some variables for topological sort
        int[] course_order = new int[numCourses];
        int[] in_count = new int[numCourses];
        Queue<Integer> incoming_edges = new LinkedList<>();
        int index = 0;
        int counter = 0;
        
        // in_count generation
        for (int prereq = 0; prereq < prerequisites.length; prereq++) {
            in_count[prerequisites[prereq][0]]++;
        }
         
        for (int i = 0; i < in_count.length; i++) {
            if (in_count[i] == 0) {
                incoming_edges.add(i);
                in_count[i] = -1;
            }
        }
        
        while(!incoming_edges.isEmpty()) {
            int currCourse = incoming_edges.remove();
            counter++;
            course_order[index] = currCourse;
            index++;
            
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == currCourse) {
                    in_count[prerequisites[i][0]]--;
                } 
            }
            
            for (int i = 0; i < in_count.length; i++) {
                if (in_count[i] == 0) {
                    incoming_edges.add(i);
                    in_count[i] = -1;
                }
            }
        }
        
        if (counter != numCourses) {
            return new int[0];
        } else {
            return course_order;
        }
        
    }
}
