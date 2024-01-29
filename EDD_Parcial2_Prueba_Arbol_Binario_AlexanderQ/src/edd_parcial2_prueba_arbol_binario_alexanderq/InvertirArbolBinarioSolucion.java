package edd_parcial2_prueba_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class InvertirArbolBinarioSolucion {
    public static Node invertirAbol(Node root) {
        if (root == null) return null;
        Node tmp = root.left;
        root.left = invertirAbol(root.right);
        root.right = invertirAbol(tmp);
        return root;
    }

}
