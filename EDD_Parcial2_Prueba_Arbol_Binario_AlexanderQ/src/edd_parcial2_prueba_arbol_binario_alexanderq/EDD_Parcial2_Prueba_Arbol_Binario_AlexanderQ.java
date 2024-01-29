package edd_parcial2_prueba_arbol_binario_alexanderq;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial2_Prueba_Arbol_Binario_AlexanderQ {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int opc;
        Node root = new Node(4);
        do{
            System.out.println("1: Invertir Arbol");
            System.out.println("2: Lista Enlazada");
            System.out.println("3: Profundidad Maxima del Arbol");
            System.out.println("4: Arbol Binario de Busqueda");
            System.out.println("5: SubArbol");
            System.out.println("6: Ancestro Comun");
            System.out.println("7: Salir");
            opc = tec.nextInt();
            switch(opc){
                case 1:
                    System.out.println("------------------Invertir Arbol------------------");
                    InvertirArbolBinario invertirArbolBinario = new InvertirArbolBinario ();
                    
                    root.left = new Node(2);
                    root.right = new Node(7);
                    root.left.left = new Node(1);
                    root.left.right = new Node(3);
                    root.right.left = new Node(6);
                    root.right.right = new Node(9);
                    
                    System.out.print("PRE-ORDER TRAVERSAL: ");
                    ArbolBinario.preOderTraversal(root);
                    System.out.println();
                    
                    Node newRoot = InvertirArbolBinarioSolucion. invertirAbol(root);
                    assertEquals(4, newRoot.value);
                    assertEquals(7, newRoot.left.value);
                    assertEquals(2, newRoot.right.value);
                    assertEquals(9, newRoot.left.left.value);
                    assertEquals(6, newRoot.left.right.value);
                    assertEquals(3, newRoot.right.left.value);
                    assertEquals(1, newRoot.right.right.value);

                    System.out.print("PRE-ORDER TRAVERSAL: ");
                    ArbolBinario.preOderTraversal(root);
                    System.out.println();

                    break;
                case 2:
                    System.out.println("------------------Lista Enlazada------------------");
                    ListOfDepths listOfDepths = new ListOfDepths();
                    //Node root = new Node(4);
                    root.left = new Node(2);
                    root.right = new Node(7);
                    root.left.left = new Node(1);
                    root.left.right = new Node(3);
                    root.right.left = new Node(6);
                    root.right.right = new Node(9);
                    List<LinkedList<Node>> result = ListOfDepthsSolution.listOfDepths(root);
                    assertEquals(4, result.get(0).get(0).value);
                    assertEquals(2, result.get(1).get(0).value);
                    assertEquals(7, result.get(1).get(1).value);
                    assertEquals(1, result.get(2).get(0).value);
                    assertEquals(3, result.get(2).get(1).value);
                    assertEquals(6, result.get(2).get(2).value);
                    assertEquals(9, result.get(2).get(3).value);
                    ListOfDepthsSolution solucion = new ListOfDepthsSolution();
                    solucion.printListOfDepths(result);
                    break;
                case 3:
                    System.out.println("-----------Profundidad Maxima del Arbol-----------");
                    MaximumDepthSolution maxDepth = new MaximumDepthSolution();
                    
                    root.left = new Node(2);
                    root.right = new Node(7);
                    root.left.left = new Node(1);
                    root.left.right = new Node(3);
                    assertEquals(3, maxDepth.maxDepth(root));
                    root.left.left.left = new Node(8);
                    assertEquals(4, maxDepth.maxDepth(root));
                    
                    System.out.println("SubArbol: "+maxDepth.maxDepth(root));
                    
                    break;
                case 4:
                    System.out.println("-------------Arbol Binario de Busqueda------------");
                    ValidateBSTSolution validateBst = new ValidateBSTSolution();
                    root.left = new Node(5);
                    root.right = new Node(7);
                    root.left.left = new Node(1);
                    root.left.right = new Node(3);
                    root.left.left.left = new Node(8);
                    assertFalse(validateBst.isValidBST(root));
                    root.left.value = 2;
                    root.left.left.left = null;
                    assertTrue(validateBst.isValidBST(root));
                    System.out.println("Es arbol de busqueda: "+validateBst.isValidBST(root));
                    break;
                case 5:
                    System.out.println("---------------------SubArbol---------------------");
                    IsSubTreeSolution isSubTree = new IsSubTreeSolution();
                    Node first = new Node(4);
                    first.left = new Node(5);
                    first.right = new Node(7);
                    first.left.left = new Node(1);
                    first.left.right = new Node(3);
                    first.left.left.left = new Node(8);
                    Node second = new Node(5);
                    second.left = new Node(1);
                    second.right = new Node(3);
                    second.left.left = new Node(8);
                    assertTrue(isSubTree.isSubtree(first, second));
                    second.right.right = new Node(12);
                    assertFalse(isSubTree.isSubtree(first, second));
                    
                    System.out.println("SubArbol: "+isSubTree.isSubtree(first, second));
                    break;
                case 6:
                    System.out.println("------------------Ancestro Comun------------------");
                    break;
                case 7:
                    System.out.println("Saliendo ....");
                    break;
                default:
                    break;
            }
        }while(opc != 7);
        
    }
}
