public class Node {
    private Friend friend; // Значение
    private Node leftChild; // Левый потомок
    private Node rightChild; // Правый потомок
    private boolean isDeleted;

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Node(Friend friend) {
        this.friend = friend;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "friend=" + friend.toString() +
                ", leftChild=" + leftChild.getFriend().toString() +
                ", rightChild=" + rightChild.getFriend().toString() +
                '}';
    }
}
