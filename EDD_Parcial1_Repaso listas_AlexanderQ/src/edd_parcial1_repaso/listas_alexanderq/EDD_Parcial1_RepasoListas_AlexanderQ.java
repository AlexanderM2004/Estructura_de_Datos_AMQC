package edd_parcial1_repaso.listas_alexanderq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alexander Quizhpe
 */

public class EDD_Parcial1_RepasoListas_AlexanderQ {
    public static void main(String[] args) throws IOException {
        // definir el método BufferedReader
        //porque debemos capturar n atletas
        BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));

        // caturar la cantidad de atletas
        System.out.println("Ingres el  N cantidad de Atletas");
        // guardamos en una variable N
        // llamamos la clase Integer.parseInt readLine
        int N=Integer.parseInt(bfr.readLine());
        // creamos un objeto de la clase competencia
        Competencias competencia=new Competencias(N);

        //  LLAMMAOS LE METODO InciarCompetencia
        competencia.IniciarCompetencia();
    }
    
}
