import exceptions.EmptyQueueException;

public class Queue<T> {

    class Node {
        private T value;
        private Node nextNode;
        private Integer priority = -1;

        public Node(T value){
            this.value = value;
        }

        public Node(T value, Integer priority) {
            this.value = value;
            this.priority = priority;
        }

        public T getValue() {
            return this.value;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }

    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void enqueue(T element) {
        enqueue(element, -1);
    }

    public void enqueue(T element, Integer priority) {
        Node newNode = new Node(element, priority);

        if (size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            insertNode(newNode);
        }

        this.size++;
    }

    public T dequeue() throws EmptyQueueException {
        if (this.size < 1) {
            throw new EmptyQueueException("Queue is empty!");
        }

        Node removedNode = this.head;

        this.head = this.head.getNextNode();
        this.size--;

        return removedNode.getValue();
    }

    public T peek() {
        return this.head.getValue();
    }

    public int size() {
        return this.size;
    }

    private void insertNode(Node node) {
        Node currentNode = this.head;

        if (currentNode.getPriority() < node.getPriority()) {
            node.setNextNode(currentNode);
            this.head = node;
        } else {
            Node nextNode = currentNode;
            while (nextNode != null && nextNode.getPriority() >= node.getPriority()) {
                currentNode = currentNode.getNextNode();
                nextNode = nextNode.getNextNode();
            }
            currentNode.setNextNode(node);
            node.setNextNode(nextNode);

            if (nextNode == null) {
                this.tail = node;
            }
        }
    }

}
