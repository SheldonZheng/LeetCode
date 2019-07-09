/**
 * LeetCode 146 LRU Cache 1
 */

class LRUCache {

    Map<Integer, Integer> container;
    LinkedList<Integer> linkedList;
    int capacity;

    public LRUCache(int capacity) {
        int size = ((int) Math.ceil(capacity / 0.75));
        container = new HashMap<Integer, Integer>(size);
        linkedList = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!container.containsKey(key)) {
            return -1;
        }
        int index = linkedList.indexOf(key);
        linkedList.remove(index);
        linkedList.addFirst(key);
        return container.get(key);
    }

    public void put(int key, int value) {
        if (!container.containsKey(key)) {
            if (linkedList.size() >= capacity) {
                Integer e = linkedList.removeLast();
                container.remove(e);
            }
            linkedList.addFirst(key);
        }
        int index = linkedList.indexOf(key);
        linkedList.remove(index);
        linkedList.addFirst(key);
        container.put(key, value);
    }
}
