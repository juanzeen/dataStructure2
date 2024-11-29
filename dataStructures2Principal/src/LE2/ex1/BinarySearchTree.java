package LE2.ex1;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void addValue(int value){
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }


    public int height(){
        return calculusHeight(root);
    }

    private int calculusHeight(Node root){
        if(root == null){
            return 0;
        }
        int right_height = calculusHeight(root.right);
        int left_height = calculusHeight(root.left);
        if(right_height > left_height){
            return right_height + 1;
        }
        else{
            return left_height + 1;
        }
    }

}
