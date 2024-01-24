package edd_parcial2_practica7_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial2_Practica7_Arbol_Binario_AlexanderQ {

    public static void main(String[] args) {
        Nodo root = new Nodo(1);
        root.left = new Nodo(2);
        root.right = new Nodo(3);

        root.left.left = new Nodo(4);
        root.left.right = new Nodo(5);

        root.right.right = new Nodo(6);

        root.left.left.left = new Nodo(7);

        root.left.right.left = new Nodo(8);

        System.out.print("IN-ORDER TRAVERSAL: ");
        ArbolBinario.inOrderTraversal(root);
        System.out.println();

        System.out.print("PRE-ORDER TRAVERSAL: ");
        ArbolBinario.preOderTraversal(root);
        System.out.println();

        System.out.print("POST-ORDER TRAVERSAL: ");
        ArbolBinario.postOrderTraversal(root);
        System.out.println();
        
        
    }
    
}
