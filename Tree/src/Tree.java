public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insertFriend(Friend friend){
        Friend currentFriend = new Friend(friend.getID(), friend.getName(), friend.getAge());
        Node newNode = new Node(currentFriend);
        if (root == null)
            root = newNode;
        else {
            Node currentNode = root;
            Node parrent;
            while (true){
             parrent = currentNode;
                if (newNode.getFriend().getID() < parrent.getFriend().getID()){
                    currentNode = parrent.getLeftChild();
                    if (currentNode == null){
                        parrent.setLeftChild(newNode);
                        return;
                    }
            } else {
                    currentNode = parrent.getRightChild();
                    if (currentNode == null){
                        parrent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public Node find(int id){
        Node current = root;
        while (current.getFriend().getID() != id){
            if (id < current.getFriend().getID()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }

    public void printTree(Node node){
        if (node != null){
            printTree(node.getLeftChild());
            System.out.println(node.getFriend().toString() +
                    "\n============================\n");
            printTree(node.getRightChild());
        }
    }

    public Node findMinimum(){
        Node current, last = null;
        current = root;
        while (current != null){
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node findMaximum(){
        Node current, last = null;
        current = root;
        while (current != null){
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

    public boolean delete(int key){
        Node current = root;
        Node parrent = root;
        boolean isLeftChild = true;
        // Поиск необходимого элемента. . .
        while (current.getFriend().getID() != key ) {
            parrent = current;
            if (key < current.getFriend().getID()) {
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }
            // Необходимый элемент найден. . .
            // Удаление, если потомков узла нет. . .
                if (current.getLeftChild() == null && current.getRightChild() == null) {
                    if (current == root){
                        root = null;
                    } else if (isLeftChild){
                        parrent.setLeftChild(null);
                    } else
                        parrent.setRightChild(null);
                }
            // Удаление, если у узла нет левого потомка. . .
                else if(current.getLeftChild() == null) {
                    if (current == root)
                        root = current.getRightChild();
                    else if (isLeftChild)
                        parrent.setLeftChild(current.getRightChild());
                    else
                        parrent.setRightChild(current.getRightChild());
                    // Удаление, если у узла нет правого потомка
                } else if (current.getRightChild() == null) {
                    if (current == root)
                        root = current.getLeftChild();
                    else if (isLeftChild)
                        parrent.setLeftChild(current.getLeftChild());
                    else
                        parrent.setRightChild(current.getLeftChild());
                } else  // Если у узла 2 потомка
                {
                    Node successor = getSuccessor(current);
                    if (current == root)
                        root = successor;
                    else if (isLeftChild)
                        parrent.setLeftChild(successor);
                    else
                        parrent.setRightChild(successor);

                    successor.setLeftChild(current.getLeftChild());
                }
                return true;
    }

    private Node getSuccessor(Node delNode){
        Node parentSuccessor = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();
        while (current != null){
            parentSuccessor = successor;
            successor = current;
            current = current.getLeftChild();
        } if (successor != delNode.getRightChild()){
            parentSuccessor.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
            return successor;
    }
}
