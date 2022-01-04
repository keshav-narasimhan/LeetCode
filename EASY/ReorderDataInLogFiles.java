class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // initialize ArrayList to sort the logs
        ArrayList<LogFiles> toSort = new ArrayList<>();
        ArrayList<String> digLogs = new ArrayList<>();
        
        // populate the 'toSort' ArrayList with LogFiles objects
        for (int i = 0; i < logs.length; i++) {
            String currWord = logs[i];
            int indFirstSpace = currWord.indexOf(" ");
            
            // if the log is a digit-log => add to 'digLogs'
            if (Character.isDigit(currWord.charAt(indFirstSpace + 1))) {
                digLogs.add(logs[i]);
            } 
            // if the log is a letter-log => add to 'toSort' as a LogFiles object
            else {
                LogFiles currLog = new LogFiles(currWord.substring(0, indFirstSpace), currWord.substring(indFirstSpace + 1), i);
                toSort.add(currLog);
            }
        }
        
        // sort the logs
        Collections.sort(toSort);
        
        // obtain the log files in order
        String [] orderedFiles = new String[logs.length];
        for (int i = 0; i < toSort.size(); i++) {
            orderedFiles[i] = logs[toSort.get(i).index];
        }
        
        // add the digit-logs in inputted order
        for (int i = toSort.size(); i < logs.length; i++) {
            orderedFiles[i] = digLogs.get(i - toSort.size());
        }
        
        // return the new ordered list
        return orderedFiles;
    }
}

// created class in order to sort the letter-logs
class LogFiles implements Comparable<LogFiles> {
    public String ID;
    public String CONTENT;
    public int index;
    
    public LogFiles(String id, String content, int ind) {
        this.ID = id;
        this.CONTENT = content;
        this.index = ind;
    }
    
    @Override
    public int compareTo(LogFiles other) {
        if (this.CONTENT.compareTo(other.CONTENT) > 0) {
            return 1;
        } else if (this.CONTENT.compareTo(other.CONTENT) < 0) {
            return -1;
        } else {
            if (this.ID.compareTo(other.ID) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
