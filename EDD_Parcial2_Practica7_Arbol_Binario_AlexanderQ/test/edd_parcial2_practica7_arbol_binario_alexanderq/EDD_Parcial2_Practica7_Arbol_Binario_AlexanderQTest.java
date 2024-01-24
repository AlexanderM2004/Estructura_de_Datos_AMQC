/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edd_parcial2_practica7_arbol_binario_alexanderq;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ESPE
 */
public class EDD_Parcial2_Practica7_Arbol_Binario_AlexanderQTest {
    
    public EDD_Parcial2_Practica7_Arbol_Binario_AlexanderQTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class EDD_Parcial2_Practica7_Arbol_Binario_AlexanderQ.
     */
    @Test
    public void testMain() {
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
