package LE2.ex1;

public class AvlTree {

    Node root;
    public AvlTree(){
        root = null;
    }

    public int height() {
        return node_height(root);
    }

    public void addValue(int value) {
        root = insert(root, value);
    }

    private int node_height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int balancingFactor(Node node) {
        return node == null ? 0 : node_height(node.left) - node_height(node.right);
    }

    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(node_height(node.left), node_height(node.right));
        }
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private Node ll_Rotation(Node y) { // esquerda-esquerda
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rr_Rotation(Node y){ //rotação simples a esquerda, por isso "right-right"
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node insert(Node currentNode, int number) {
        if (currentNode == null) {
            return new Node(number);
        }

        if (number < currentNode.data) {
            currentNode.left = insert(currentNode.left, number);
        } else if (number > currentNode.data) {
            currentNode.right = insert(currentNode.right, number);
        }

        updateHeight(currentNode);
        return balance(currentNode);
    }

    private Node balance(Node node) {
        if (node == null) return null;

        int factor = balancingFactor(node);

        if (factor > 1) {
            if (balancingFactor(node.left) >= 0) {
                return ll_Rotation(node);
            }

            node.left = rr_Rotation(node.left); // Esquerda-direita
            return ll_Rotation(node);
        }

        if (factor < -1) {
            if (balancingFactor(node.right) <= 0) {
                return rr_Rotation(node);  // rotação à esquerda
            }
            // direita-esquerda
            node.right = ll_Rotation(node.right);
            return rr_Rotation(node);
        }

        return node;
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
