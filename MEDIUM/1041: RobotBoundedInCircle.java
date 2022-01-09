class Solution {
    public boolean isRobotBounded(String instructions) {
        // location of the robot
        int xPos = 0;
        int yPos = 0;
        
        /*
         * north = 0
         * east = 1
         * south = 2
         * west = 3
         */
        int direction = 0;
        
        // used for the current instruction
        char move;
        
        // loop for at most 4 instruction lengths (account for turning on last move)
        for (int i = 0; i < 4; i++) {
            // calculate the ending position based on the instructions given
            for (int j = 0; j < instructions.length(); j++) {
                move = instructions.charAt(j);
                
                // update the robot's position
                if (move == 'G') {
                    if (direction == 0) {
                        yPos++;
                    } else if (direction == 1) {
                        xPos++;
                    } else if (direction == 2) {
                        yPos--;
                    } else {
                        xPos--;
                    }
                } 
                // turn the robot left
                else if (move == 'L') {
                    direction--;
                    if (direction == -1) {
                        direction = 3;
                    }
                } 
                // turn the robot right
                else {
                    direction++;
                    if (direction == 4) {
                        direction = 0;
                    }
                }
            }
            
            // check if the robot returns to the starting position => circle exists
            if (xPos == 0 && yPos == 0) {
                return true;
            }
            
        }
        
        // there exists no circle
        return false;
    }
}
