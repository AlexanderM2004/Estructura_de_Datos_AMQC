package edd_parcial2_prueba_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class MaximumDepthSolution {
    public static int maxDepth(Node root) {
        if (root == null) return 0;
        int depthLeft = maxDepth(root.left) + 1;
        int depthRight = maxDepth(root.right) + 1;
        return Math.max(depthLeft, depthRight);
    }
}
