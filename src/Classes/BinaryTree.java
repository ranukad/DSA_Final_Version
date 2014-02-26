/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thilina
 */
public class BinaryTree {

    public Node root;
    public Node returnNode;
    private static int pos;
    ArrayList<Integer> lstSort = new ArrayList<Integer>();

    // constructor ;
    // constructor 
    public BinaryTree() {
        root = null;
    }

    // pass the root Node
    public Node getRoot() {
        return root;
    }

    // inserting a node to the tree
    public void insert(int key) {

        Node newInsertnode = new Node(key);

        if (root == null) {
            root = newInsertnode;
            lstSort.add(root.getKey());
        } else {

            traverseAndAddNode(root, newInsertnode);

        }
    }

    // Delete a node from the tree
    public boolean delete(int value) {

        Node nodeTobeDeleted = find(value);

        if (nodeTobeDeleted != null) {
            if (nodeTobeDeleted.getLeftChild() == null && nodeTobeDeleted.getRightChild() == null) {
                // Where Both leftchild and rightChild doesnot exsit in the tree
                deleteCase1(nodeTobeDeleted);
            } else if (nodeTobeDeleted.getLeftChild() != null) {
                // Where leftChild should be Deleted
                deleteCase2(nodeTobeDeleted);
            } else if (nodeTobeDeleted.getRightChild() != null && nodeTobeDeleted.getLeftChild() != null) {
                // Where rightChild Should be Deleted 
                deleteCase3(nodeTobeDeleted);
            } else if (nodeTobeDeleted.getRightChild() != null) {
                deleteCase2(nodeTobeDeleted);
            }
        }

        return false;
    }

    private void deleteCase1(Node nodeTobeDeleted) {

        if (nodeTobeDeleted.getParent().getLeftChild() == nodeTobeDeleted) {

            nodeTobeDeleted.getParent().setLeftChild(null);

        } else if (nodeTobeDeleted.getParent().getRightChild() == nodeTobeDeleted) {

            nodeTobeDeleted.getParent().setRightChild(null);

        }
    }

    // find a node in the tree
    public Node find(int value) {
        if (root != null) {
            // if the root is null there is no tree to find a node;
            //  if the root is not null node is searching recersivly 
            return findNode(root, new Node(value));
        }
        return null;
    }

    // find the node with a relevent key 
    private Node findNode(Node search, Node node) {

        if (search == null) {
            return null;
        }

        if (search.getKey() == node.getKey()) {
            return search;

        } else {
            returnNode = findNode(search.getLeftChild(), node);

            if (returnNode == null) {
                returnNode = findNode(search.getRightChild(), node);
            }
            return returnNode;
        }

    }

    private void deleteCase2(Node nodeTobeDeleted) {

        if (nodeTobeDeleted.getParent().getLeftChild() == nodeTobeDeleted) {

            if (nodeTobeDeleted.getLeftChild() != null) {

                nodeTobeDeleted.getParent().setLeftChild(nodeTobeDeleted.getLeftChild());

            } else if (nodeTobeDeleted.getRightChild() != null) {
                nodeTobeDeleted.getParent().setLeftChild(nodeTobeDeleted.getRightChild());
            }
        } else if (nodeTobeDeleted.getParent().getRightChild() == nodeTobeDeleted) {

            if (nodeTobeDeleted.getLeftChild() != null) {

                nodeTobeDeleted.getParent().setRightChild(nodeTobeDeleted.getLeftChild());

            } else if (nodeTobeDeleted.getRightChild() != null) {
                nodeTobeDeleted.getParent().setRightChild(nodeTobeDeleted.getRightChild());
            }

        }
    }

    private void deleteCase3(Node nodeTobeDeleted) {

        Node minNode = minLeftTraversal(nodeTobeDeleted.getRightChild());

        deleteCase2(minNode);

        minNode.setParent(nodeTobeDeleted.getParent());
        minNode.setLeftChild(nodeTobeDeleted.getLeftChild());
        minNode.setRightChild(nodeTobeDeleted.getRightChild());

        if (nodeTobeDeleted.getParent() == null) {
            root = minNode;
        } else {
            if (nodeTobeDeleted.getParent().getLeftChild() == nodeTobeDeleted) {

                nodeTobeDeleted.getParent().setLeftChild(minNode);

            } else if (nodeTobeDeleted.getParent().getRightChild() == nodeTobeDeleted) {

                nodeTobeDeleted.getParent().setRightChild(minNode);
            }
        }
    }

    // travel the tree for delete the node
    private Node minLeftTraversal(Node node) {
        if (node.getLeftChild() == null) {
            return node;
        }
        return minLeftTraversal(node.getLeftChild());
    }

    // find the place before adding the node
    private void traverseAndAddNode(Node node, Node newInsertnode) {
        if (newInsertnode.getKey() < node.getKey()) {

            if (node.getLeftChild() == null) {

                newInsertnode.setParent(node);
                node.setLeftChild(newInsertnode);
                // Insert left side nodes to the array list
                lstSort.add(newInsertnode.getKey());
            } else {

                traverseAndAddNode(node.getLeftChild(), newInsertnode);
            }

        } else if (newInsertnode.getKey() > node.getKey()) {

            if (node.getRightChild() == null) {

                newInsertnode.setParent(node);
                node.setRightChild(newInsertnode);
                // insert right side nodes to the array list
                lstSort.add(newInsertnode.getKey());
            } else {

                traverseAndAddNode(node.getRightChild(), newInsertnode);
            }
        }
    }

    // taverse the tree through the nodes
    public void traverse() {
        if (root != null) {
            // if the root is empty there is no tree to be traverse , so the game close 
            // if not the root is not empty 
            Node nodetreverse = root;
            if (nodetreverse.getLeftChild() == null && nodetreverse.getRightChild() == null) {
                System.out.println(nodetreverse.getKey());
            } else {
                if (nodetreverse.getLeftChild() != null) {

                    // if the left child of the node is null recursive call for the method Inordertraverse
                    Inordertraverse(nodetreverse.getLeftChild());

                }
                if (nodetreverse.getRightChild() != null) {

                    // if the right child of the node null recursive call for the method Inordertraverse
                    Inordertraverse(nodetreverse.getRightChild());

                }
            }

        }

    }

    // transversal through the nodes and print the nodes
    private void Inordertraverse(Node node) {

        if (node.getLeftChild() != null) {

            Inordertraverse(node.getLeftChild());

        }

        System.out.println(node.getKey());
        // System.out.print(lstSort);
        if (node.getRightChild() != null) {

            Inordertraverse(node.getRightChild());

        }
    }

    // count the number of nodes in the tree 
    private int CountNodes(Node root) {
        int numberofNodes = 1;
        if (root == null) {
            return -1;
        } else {
            if (root.getLeftChild() != null) {
                numberofNodes += CountNodes(root.getLeftChild());
            }
            if (root.getRightChild() != null) {
                numberofNodes += CountNodes(root.getRightChild());
            }
            return numberofNodes;
        }
    }

    public int CountNodes() {
        return root == null ? 0 : CountNodes(root);
    }

    // sorted the array list inorder
    public void SortPrint() {

        System.out.print(MergeSort.mergeSort(lstSort));

    }

    // Load ISBN code from database and put that in a tree
    public void getBookTree() {

        // ArrayList<Integer> IsbnData = new ArrayList<Integer>();
        try {
            ResultSet rs = null;
            ConnectionClass connection = new ConnectionClass();
            Connection c = connection.getConnection();
            String sql = "select ISBN  from books";
            PreparedStatement pst = c.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
               // IsbnData.add(rs.getInt(1)); 
                this.insert(rs.getInt(1));
            }
            // System.out.print(IsbnData);
            // for testing purpose ;
            this.traverse();
        } catch (Exception ex) {
             System.out.print(ex.getMessage());
        }

    }

}
