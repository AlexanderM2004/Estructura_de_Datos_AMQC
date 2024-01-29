package edd_parcial2_prueba_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class IsSubTreeSolution {
    public boolean isSubtree(Node first, Node second) {
        StringBuilder stb1 = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();
        preOrder(first, stb1);
        preOrder(second, stb2);
        return stb1.toString().contains(stb2.toString());
    }
    
    private void preOrder(Node node, StringBuilder stb) {
        if (node == null) {
            stb.append("X");
            return;
        }
        stb.append(node.value);
        preOrder(node.left, stb);
        preOrder(node.right, stb);
    }

}
