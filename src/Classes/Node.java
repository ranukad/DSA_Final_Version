/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Hp
 */
public class Node {
    // Private data items
    private Node left;
    private Node right;
    private Node parent;   // keep a refrence 
    private int key;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }
    public Node (){
        
    }

    public void setLeftChild(Node left) {
        this.left = left;
    }

    public void setRightChild(Node right) {
        this.right = right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return left;
    }

    public Node getRightChild() {
        return right;
    }

    public int getKey() {
        return key;
    }

    public Node getParent() {
        return parent;
    }

     
}
