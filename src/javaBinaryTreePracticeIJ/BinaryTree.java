package javaBinaryTreePracticeIJ;

import javax.xml.soap.Node;

public class BinaryTree {
  Node root;

  public void add(int value) {
    root = addRecursive(root, value);
  }

  //recursive method to do the insertion
  private Node addRecursive(Node current, int value) {
    if (current == null) {
      return new Node(value);
    }
    if (value < current.value) {
      current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
      current.right = addRecursive(current.right, value);
    }
    return current;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public int getSize() {
    return getSizeRecursive(root);
  }

  private int getSizeRecursive(Node current) {
    return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
  }

  public boolean containsNode(int value) {
    return containsNodeRecursive(root, value);
  }

  private boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
      return false;
    }
    return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
  }

  public void delete(int value) {
    root = deleteRecursive(root, value);
  }

  private Node deleteRecursive(Node current, int value) {
    if (current == null) {
      return null;
    }
    if (value == current.value) {
      // Case 1: no children
      if (current.left == null && current.right == null) {
        return null;
      }
      // Case 2: only 1 chiuld
      if (current.right == null) {
        return current.left;
      }
      if (current.left == null) {
        return current.right;
      }
      // Case 3: 2 children
      int smallestValue = findSmallestValue(current.right);
      current.value = smallestValue;
      current.right = deleteRecursive(current.right, smallestValue);
      return current;
    }
    if (value < current.value) {
      current.left = deleteRecursive(current.left, value);
      return current;
    }
    current.right = deleteRecursive(current.right, value);
    return current;
  }

  private int findSmallestValue(Node root) {
    return root.left == null ? root.value : findSmallestValue(root.left);
  }

  public void traverseInOrder(Node node) {
    if (node != null) {
      traverseInOrder(node.left);
      visit(node.value);
      traverseInOrder(node.right);
    }
  }

  

}