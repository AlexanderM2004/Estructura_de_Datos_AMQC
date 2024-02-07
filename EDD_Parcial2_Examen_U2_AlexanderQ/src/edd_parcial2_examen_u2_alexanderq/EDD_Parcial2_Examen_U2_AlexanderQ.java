package edd_parcial2_examen_u2_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial2_Examen_U2_AlexanderQ {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int opc;
        Directorio usser = null;
        Directorio carp1 = null;
        Directorio carp2 = null;
        Directorio carp3 = null;
        boolean marc = false, band = false, sub1 = false, sub2 = false, sub3=false;
        String subnom = "";
        String subnom2 = "";
        String subnom3 = "";
        String nomArchi;
        do{
            System.out.println("1: Crear Directorio");
            System.out.println("2: Crear SubDirectorio");
            System.out.println("3: Crear archivo en directorio");
            System.out.println("4: Elimiar Directorio");
            System.out.println("5: Eliminar Archivo");
            System.out.println("6: Buscar Archivo");
            System.out.println("7: Mostrar Directorios y Archivos");
            System.out.println("8: Salir");
            System.out.println("------------------------------------------------------------");
            opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    marc = true;
                    System.out.println("----------------------Crear Directorio----------------------");
                    System.out.print("Nombre de Directorio: ");
                    String nombDir = tec.nextLine();
                    usser = new Directorio(nombDir);
                    System.out.println("Directorio "+nombDir+", creado exitosamente ");
                    break;
                case 2:
                    marc = true;
                    System.out.println("--------------------Crear SubDirectorio---------------------");
                    System.out.print("Cantidad de subdirectoios a crear: ");
                    int cant = tec.nextInt();
                    //tec.nextInt();
                    if(cant == 1){
                        sub1=true;
                        System.out.print("Nombre de subdirectorio:");
                        subnom = tec.nextLine();
                        carp1 = new Directorio(subnom);
                        usser.agregarSubdirec(carp1);
                        
                    }else if(cant == 2){
                        sub2=true;
                        System.out.print("Nombre de subdirectorio 1:");
                        subnom = tec.nextLine();
                        carp1 = new Directorio(subnom);
                        System.out.println("");
                        System.out.print("Nombre de subdirectorio 2:");
                        subnom2 = tec.nextLine();
                        carp2 = new Directorio(subnom2);
                        
                        usser.agregarSubdirec(carp1);
                        usser.agregarSubdirec(carp2);
                        
                    }else if(cant == 3){
                        sub3=true;
                        System.out.print("Nombre de subdirectorio 1:");
                        subnom = tec.nextLine();
                        carp1 = new Directorio(subnom);
                        System.out.println("");
                        System.out.print("Nombre de subdirectorio 2:");
                        subnom2 = tec.nextLine();
                        carp2 = new Directorio(subnom2);
                        System.out.println("");
                        System.out.print("Nombre de subdirectorio 3:");
                        subnom3 = tec.nextLine();
                        carp3 = new Directorio(subnom3);
                        
                        usser.agregarSubdirec(carp1);
                        usser.agregarSubdirec(carp2);
                        usser.agregarSubdirec(carp3);
                    }else{
                        System.out.println("Numero no valido, o sobre paso cantidad de subdirectorios permitidos");
                    }
                    break;
                case 3:
                    band = true;
                    System.out.println("-----------------Crear archivo en directorio----------------");
                    if(sub1){
                        System.out.print("Ingrese nombre del archivo: ");
                        nomArchi = tec.nextLine();
                        carp1.agregarArch(nomArchi);
                        
                    }else if(sub2){
                        System.out.println("1: Crear en "+subnom);
                        System.out.println("2: Crear en "+subnom2);
                        int opcsub = tec.nextInt();
                        tec.nextLine();
                        switch(opcsub){
                            case 1:
                                System.out.print("Ingrese nombre del archivo: ");
                                nomArchi = tec.nextLine();
                                carp1.agregarArch(nomArchi);
                                break;
                            case 2:
                                System.out.print("Ingrese nombre del archivo: ");
                                nomArchi = tec.nextLine();
                                carp2.agregarArch(nomArchi);
                                break;
                            default:
                                System.out.println("No existe el directorio");
                                break;
                        }
                        
                    }else if(sub3){
                        System.out.println("1: Crear en "+subnom);
                        System.out.println("2: Crear en "+subnom2);
                        System.out.println("3: Crear en "+subnom3);
                        int opcsub = tec.nextInt();
                        tec.nextLine();
                        switch(opcsub){
                            case 1:
                                System.out.print("Ingrese nombre del archivo: ");
                                nomArchi = tec.nextLine();
                                carp1.agregarArch(nomArchi);
                                break;
                            case 2:
                                System.out.print("Ingrese nombre del archivo: ");
                                nomArchi = tec.nextLine();
                                carp2.agregarArch(nomArchi);
                                break;
                            case 3:
                                System.out.print("Ingrese nombre del archivo: ");
                                nomArchi = tec.nextLine();
                                carp3.agregarArch(nomArchi);
                                break;
                            default:
                                System.out.println("No existe el directorio");
                                break;
                        }
                    }
                    break;
                case 4:
                    if(marc){
                        System.out.println("---------------------Elimiar Subdirectorio---------------------");
                        System.out.println("1: "+subnom);
                        System.out.println("2: "+subnom2);
                        System.out.println("3: "+subnom3);
                        int opcDele = tec.nextInt();
                        tec.nextLine();
                        switch(opcDele){
                            case 1:
                                usser.eliminarSubdirec(carp1);
                                System.out.println("Directorio eliminado exitosamente");
                                break;
                            case 2:
                                usser.eliminarSubdirec(carp2);
                                System.out.println("Directorio eliminado exitosamente");
                                break;
                            case 3:
                                usser.eliminarSubdirec(carp3);
                                System.out.println("Directorio eliminado exitosamente");
                                break;
                            default:
                                System.out.println("No existe ese directorio");
                                break;
                        }
                    }else{
                        System.out.println("Primero cree un Directorio");
                    }
                    break;
                case 5:
                    if(band){
                        System.out.println("----------------------Eliminar Archivo----------------------");
                        System.out.print("Nombre de archivo a eliminar: ");
                        String archiEli = tec.nextLine();
                        usser.eliminarArch(archiEli);
                    }else{
                        System.out.println("Primero cree un archivo");
                    }
                    break;
                case 6:
                    if(band){
                        System.out.println("-----------------------Buscar Archivo-----------------------");
                        System.out.print("Ingrese nombre de archivo a buscar: ");
                        String archBusc = tec.nextLine();
                        if (usser.buscarArch(archBusc)) {
                            System.out.println("El archivo '" + archBusc + "' se encuentra en el árbol.");
                        } else {
                            System.out.println("El archivo '" + archBusc + "' no se encuentra en el árbol.");
                        }
                    }else{
                        System.out.println("Primero cree un archivo");
                    }
                    break;
                case 7:
                    if(marc){
                        System.out.println("---------------Mostrar Directorios y Archivos---------------");
                        usser.mostrarArbol(0);
                    }else{
                        System.out.println("Primero cree directorios y archivos");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo ... XD");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada");
                    break;
            }
            System.out.println("------------------------------------------------------------");
        }while(opc !=8);
    }
}
