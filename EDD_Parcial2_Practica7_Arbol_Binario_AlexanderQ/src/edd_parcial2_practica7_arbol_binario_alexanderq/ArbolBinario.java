package edd_parcial2_practica7_arbol_binario_alexanderq;

/**
 *
 * @author Alxander Quizhpe
 */
public class ArbolBinario {
    public static void inOrderTraversal(Nodo node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.println(node.value + "");
            inOrderTraversal(node.right);
        }
    }
    
    public static void preOderTraversal(Nodo node){
        if(node != null){
            System.out.println(node.value + "");
            preOderTraversal(node.left);
            preOderTraversal(node.right);
        }
    }
    
    public static void postOrderTraversal(Nodo node){
        if(node != null){
            preOderTraversal(node.left);
            preOderTraversal(node.right);
            System.out.println(node.value + "");
        }
    }
}
