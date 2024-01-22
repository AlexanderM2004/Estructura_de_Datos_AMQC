package Test_Arbol_Binario;
import edd_parcial2_practica7_arbol_binario_alexanderq.ArbolBinario;
import edd_parcial2_practica7_arbol_binario_alexanderq.Nodo;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Alexander Quizhpe
 */
public class Test_Arbol {
    @Test
    public void test(){
        Nodo root = new Nodo(1);
        root.left = new Nodo(2);
        root.right = new Nodo(3);
        root.left.left = new Nodo(4);
        root.left.right = new Nodo(5);
        root.right.right = new Nodo(6);
        root.left.left.left = new Nodo(7);
        root.left.right.left = new Nodo(8);
        System.out.println("IN-ORDER TRAVERSAL: ");
        ArbolBinario.inOrderTraversal(root);
        System.out.println("");
        System.out.println("PRE-ORDER TRAVERSAL: ");
        ArbolBinario.preOderTraversal(root);
        System.out.println("");
        System.out.println("POST-ORDER TRAVERSAL: ");
        ArbolBinario.postOrderTraversal(root);
        System.out.println("");
    }
    
}
