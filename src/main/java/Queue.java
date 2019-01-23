public class Queue<T> {

    class Node {
        private T value;
        private Node nextNode;

        public Node(T value, Integer priority) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }
    }


}
