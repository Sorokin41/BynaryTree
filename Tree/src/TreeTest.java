import java.util.Set;
import java.util.TreeSet;

public class TreeTest {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertFriend(new Friend(4, "Pavel", 28));
        tree.insertFriend(new Friend(5, "Valera", 15));
        tree.insertFriend(new Friend(6,"Oleg", 34));
        tree.insertFriend(new Friend(1, "Vladimir", 25));
        tree.insertFriend(new Friend(2, "Egor", 25));
        tree.insertFriend(new Friend(3,"Angelina", 24));
        tree.insertFriend(new Friend(8,"Gena", 24));
        tree.insertFriend(new Friend(7,"Penis", 24));
        tree.insertFriend(new Friend(9,"Denis", 24));
        tree.find(8).setDeleted(true);



        System.out.println("All tree: \n");
        tree.printTree(tree.getRoot());

        System.out.println(tree.delete(4) + "\n");

        System.out.println("All tree after changes: \n");
        tree.printTree(tree.getRoot());
    }
}