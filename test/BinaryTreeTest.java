/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.BinaryTree;

import Classes.MergeSort;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void test() {
        BinaryTree Testtree = new BinaryTree();
        MergeSort mSort= new MergeSort();
       
        Testtree.insert(50);
        Testtree.insert(25);
        Testtree.insert(75);
        Testtree.insert(10);
        Testtree.insert(30);
        Testtree.insert(60);
        Testtree.insert(65);
        Testtree.insert(80);
        Testtree.insert(85);
        Testtree.insert(1);
        Testtree.insert(2);
       Testtree.insert(32);
       Testtree.insert(250);
       // Testtree.delete(60);
        Testtree.traverse();
        
      
      
//        System.out.println(  Testtree.find(10).getKey());
        
        System.out.println(" The Number Of Nodes Are "+Testtree.CountNodes());
        System.out.println("\n");
        Testtree.SortPrint();
       // Testtree.addArray();
        

       
    }
}

   