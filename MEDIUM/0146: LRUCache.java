class LRUCache {
    // define the list 
    CacheNodes head;
    CacheNodes tail;
    
    // HashMap to store hash results
    HashMap<Integer, CacheNodes> map;
    
    // define the capacity & the current size
    int capacity;
    int length;

    public LRUCache(int capacity) {
        // define the list
        this.head = new CacheNodes();
        this.tail = new CacheNodes();
        head.next = tail;
        tail.prev = head;
        
        // define the HashMap
        this.map = new HashMap<>();
        
        // define the capacity
        this.capacity = capacity;
        
        // define the length so far
        this.length = 0;
    }
    
    public int get(int key) {
        // return the node's value if the map contains the key
        if (map.containsKey(key)) {
            CacheNodes node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        } 
        // if the map doesn't contain the key, return the error code
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // the node already exists
        if (map.containsKey(key)) {
            CacheNodes node = map.get(key);
            node.val = value;
            node.key = key;
            removeNode(node);
            addNode(node);
        } 
        // the node doesn't exist
        else {
            // delete the least recently used node & and add the new one
            if (length == capacity) {
                CacheNodes toRemove = this.tail.prev;
                map.remove(toRemove.key);
                this.tail.prev = toRemove.prev;
                toRemove.prev.next = this.tail;
                
                CacheNodes node = new CacheNodes();
                node.key = key;
                node.val = value;
                map.put(key, node);
                addNode(node);
            } 
            // if there is still space, add a new node to the list/map
            else {
                CacheNodes node = new CacheNodes();
                node.val = value;
                node.key = key;
                map.put(key, node);
                addNode(node);
                length++;
            }
        }
    }
    
    // create a class for CacheNodes
    class CacheNodes {
        public CacheNodes prev;
        public CacheNodes next;
        public int val;
        public int key;
    }
    
    // add node as first node after head
    public void addNode(CacheNodes otherNode) {
        CacheNodes rest = this.head.next;
        
        otherNode.next = rest;
        rest.prev = otherNode;
        
        this.head.next = otherNode;
        otherNode.prev = this.head;
    }
    
    // remove the node by breaking the link
    public void removeNode(CacheNodes otherNode) {
        CacheNodes prevNode = otherNode.prev;
        CacheNodes nextNode = otherNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
