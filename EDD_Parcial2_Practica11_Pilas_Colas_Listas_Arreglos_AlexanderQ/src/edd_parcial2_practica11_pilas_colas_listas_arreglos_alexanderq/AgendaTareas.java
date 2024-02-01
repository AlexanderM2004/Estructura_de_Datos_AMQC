package edd_parcial2_practica11_pilas_colas_listas_arreglos_alexanderq;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alexander Quizhpe
 */
public class AgendaTareas extends Tarea{
    Scanner tec = new Scanner(System.in);
    String fecact = "01/02/2024";
    Stack<Tarea> agend = new Stack<>();
    Stack<Tarea> vencido = new Stack<>();
    Queue<Tarea> pend = new LinkedList<>();
    // Crear objetos de fecha a partir de las cadenas de texto
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaObj1;
    Date fechaObj2;

    boolean validar;
    public AgendaTareas(int id, String descr, String fecha, String estado) throws ParseException {
        super(id, descr, fecha, estado);
        this.fechaObj1 = formato.parse(fecact);
        this.fechaObj2 = formato.parse(fecha);
    }
    
    //Metodo para insertar elemento de la pila
    public void push(int id) throws ParseException{
        
        System.out.println("Num. Tarea: "+id);
        System.out.print("Descripcion: ");
        descr = tec.nextLine();//Permite el ingreso de nombre del cliente
        validar = descr.matches("[a-zA-Z]+");

        System.out.print("Fecha de vencimiento: ");
        fecha = tec.nextLine();//Permite el ingreso de los productos
        validar = fecha.matches("[a-zA-Z]+");

        do{
            System.out.println("1: Pendiente    2: Complentado    3: Vencido");
            System.out.print("Estado: ");
            int opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    estado = "Pendiente";
                    validar = true;
                    pend.add(new Tarea(id, descr, fecha, estado));

                    // Comparar las fechas
                    if (fechaObj1.compareTo(fechaObj2) < 0) {
                        vencido.add(id, new Tarea(id, descr, fecha, estado));//Guarda en la pila los datos ingresados
                    }
                    break;
                case 2:
                    estado = "Complentado";
                    validar = true;
                    // Comparar las fechas
                    if (fechaObj1.compareTo(fechaObj2) < 0) {
                        vencido.add(id, new Tarea(id, descr, fecha, estado));//Guarda en la pila los datos ingresados
                    }
                    agend.add(id, new Tarea(id, descr, fecha, estado));//Guarda en la pila los datos ingresados
                    break;
                case 3:
                    estado = "Vencido";
                    validar = true;
                    vencido.add(id, new Tarea(id, descr, fecha, estado));//Guarda en la pila los datos ingresados
                    break;
                default:
                    System.out.println("No existe ese estado de tarea ");
                    break;
            }
        }while(!validar);
        
        System.out.println("");
        
    }
    
    //Muestra los elementos de la pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPilaCompletado(){
        for (Tarea tare : agend) {
            System.out.println("Num. Tarea: "+tare.getId());
            System.out.println("Descripcion: "+tare.getDescr());
            System.out.println("Fecha de vencimiento: "+tare.getFecha());
            System.out.println("Estado: "+tare.getEstado());
            System.out.println("");
        }
    }
    
    //Muestra los elementos de la pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPilaPendiente(){
        for (Tarea tare : pend) {
            System.out.println("Num. Tarea: "+tare.getId());
            System.out.println("Descripcion: "+tare.getDescr());
            System.out.println("Fecha de vencimiento: "+tare.getFecha());
            System.out.println("Estado: "+tare.getEstado());
            System.out.println("");
        }
    }
    
    //Muestra los elementos de la pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPilaVencido(){
        for (Tarea tare : vencido) {
            System.out.println("Num. Tarea: "+tare.getId());
            System.out.println("Descripcion: "+tare.getDescr());
            System.out.println("Fecha de vencimiento: "+tare.getFecha());
            System.out.println("Estado: "+tare.getEstado());
            System.out.println("");
        }
    }
    
    //Clasifica los tareas 
    public void clasificarTareas(int id){
        int i = 0;
        for(Tarea pedi : pend){
            if (pedi.getId()!= id) {
                agend.add(pend.poll());
            }else{
                System.out.println("No existe ese id de Tarea");
            }
            i++;
        }
    }
    
    public void verificarfecha(String fecact){
        if(fecact.equalsIgnoreCase(fecha)){
            
        }
    }
}
