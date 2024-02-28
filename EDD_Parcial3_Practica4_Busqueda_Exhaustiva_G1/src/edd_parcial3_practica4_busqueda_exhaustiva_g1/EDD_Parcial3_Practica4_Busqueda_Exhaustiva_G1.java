package edd_parcial3_practica4_busqueda_exhaustiva_g1;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

/**
 *
 * @author Grupo 1
 */
public class EDD_Parcial3_Practica4_Busqueda_Exhaustiva_G1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fecha Autocompletada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        try {
            MaskFormatter formatter = new MaskFormatter("##/##/####");
            formatter.setPlaceholderCharacter('-');
            JFormattedTextField textField = new JFormattedTextField(formatter);
            textField.setColumns(10);

            frame.add(textField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);
    }
//        // TODO code application logic here
//        rutaActual = new int[n];
//        mejorRuta = new int[n];
//        for (int i = 0; i < n; i++) {
//            rutaActual[i] = i;
//        }
//        permutaciones(1);
//        System.out.println("Mejor ruta: " + Arrays.toString(mejorRuta));
//        System.out.println("Distancia total: " + mejorDistancia);
    }
//    
//    private static int[][] distancias = {
//            {0, 10, 15, 20},
//            {10, 0, 35, 25},
//            {15, 35, 0, 30},
//            {20, 25, 30, 0}
//    };
//
//    private static int n = 4; // Número de ciudades
//    private static int[] rutaActual;
//    private static int[] mejorRuta;
//    private static int mejorDistancia = Integer.MAX_VALUE;
//    
//    private static void permutaciones(int k) {
//        if (k == n) {
//            int distancia = calcularDistancia(rutaActual);
//            if (distancia < mejorDistancia) {
//                mejorDistancia = distancia;
//                System.arraycopy(rutaActual, 0, mejorRuta, 0, n);
//            }
//        } else {
//            for (int i = k; i < n; i++) {
//                intercambiar(k, i);
//                permutaciones(k + 1);
//                intercambiar(k, i);
//            }
//        }
//    }
//
//    private static void intercambiar(int i, int j) {
//        int temp = rutaActual[i];
//        rutaActual[i] = rutaActual[j];
//        rutaActual[j] = temp;
//    }
//
//    private static int calcularDistancia(int[] ruta) {
//        int distancia = 0;
//        for (int i = 0; i < n - 1; i++) {
//            distancia += distancias[ruta[i]][ruta[i + 1]];
//        }
//        distancia += distancias[ruta[n - 1]][ruta[0]]; // Volver al inicio
//        return distancia;
//    }
