class LRUCache {
public:
    class Node {
    public:
        int key, val;
        Node* prev;
        Node* next;

        // constructor of the Node class
        Node(int k, int v) {
            key = k;
            val = v;
            prev = next = NULL;
        }
    };

    // create 2 pointer by using Node class
    Node* head = new Node(-1, -1);
    Node* tail = new Node(-1, -1);

    unordered_map<int, Node*> m;
    int limit;

    void addNode(Node* newNode) {  // O(1)
        Node* oldNext = head->next;

        head->next = newNode;
        oldNext->prev = newNode;

        newNode->next = oldNext;
        newNode->prev = head;
    }

    void deleteNode(Node* oldNode) {  // O(1)
        Node* oldPrev = oldNode->prev;
        Node* oldNext = oldNode-> next;

        oldPrev->next = oldNext;
        oldNext->prev = oldPrev;
    }


    LRUCache(int capacity) {
        limit = capacity;

        // initialization time
        head->next = tail;
        tail->prev = head;
    }

    int get(int key) {  // to get the keys value  tc O(1)

        if(m.find(key) == m.end()) {
            return -1;
        }

        Node* ansNode = m[key];
        int ans = ansNode->val;
        
        m.erase(key);
        deleteNode(ansNode);

        // create most recent item
        addNode(ansNode);
        m[key] = ansNode;

        return ans;

    }

    void put(int key, int value) {  // O(1)
        // check it is already exist or not

        if(m.find(key) != m.end()) {  // already exist
            Node* oldNode = m[key];

            deleteNode(oldNode);  //  function call

            m.erase(key); // key is erase from map, who is deleted

        }

        // cache capacity reach
        if(m.size() == limit) {
            // delete LRU data
            m.erase(tail->prev->key);
            deleteNode(tail->prev);
        }

        Node* newNode = new Node(key, value);
        addNode(newNode);
        m[key] = newNode;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */