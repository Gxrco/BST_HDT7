package JUnit;

import Model.Association;
import Model.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void insertionTest(){
        ArrayList<String> elements = new ArrayList<>();
        elements.add("1"); elements.add("2");
        Association<String, ArrayList<String>> assoc = new Association<>("numbers", elements);
        BinaryTree<String, ArrayList<String>> newTree = new BinaryTree<>(assoc);
        assertTrue(newTree.contains("numbers"));
    }

    @Test
    void searchMethod(){
        ArrayList<String> elements = new ArrayList<>();
        elements.add("1"); elements.add("2");
        Association<String, ArrayList<String>> assoc = new Association<>("numbers", elements);
        BinaryTree<String, ArrayList<String>> newTree = new BinaryTree<>(assoc);
        Association<String, ArrayList<String>> assoc2 = new Association<>("numbers2", elements);
        newTree.insert(assoc2);
        assertTrue(newTree.contains("numbers2"));

    }
}