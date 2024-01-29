package edd_parcial2_prueba_arbol_binario_alexanderq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alexander Quizhpe
 */
public class ListOfDepthsSolution {
    public static List<LinkedList<Node>> listOfDepths(Node root) {
        if (root == null) {
            return null;
        }
        List<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<Node>();
            for (Node node : parents) {
                if (node.left != null) {
                    current.add(node.left);
                }
                if (node.right != null) {
                    current.add(node.right);
                }
            }
        }
        return result;
    }
    
    // Método para imprimir los resultados de ListOfDepths de manera legible
    public void printListOfDepths(List<LinkedList<Node>> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.print("Level " + i + ": ");
            LinkedList<Node> currentLevel = result.get(i);
            for (Node node : currentLevel) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }
}
