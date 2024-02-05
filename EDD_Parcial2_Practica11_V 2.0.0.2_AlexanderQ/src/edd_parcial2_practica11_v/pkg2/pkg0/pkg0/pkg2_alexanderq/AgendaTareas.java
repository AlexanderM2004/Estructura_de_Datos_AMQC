package edd_parcial2_practica11_v.pkg2.pkg0.pkg0.pkg2_alexanderq;

import java.text.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Alexander Quizhpe
 */
public class AgendaTareas extends Tarea{
    Scanner tec = new Scanner(System.in);
    Stack<Tarea> agend = new Stack<>();
    Stack<Tarea> vencido = new Stack<>();
    Queue<Tarea> pend = new LinkedList<>();
    boolean validar = false;

    public AgendaTareas(int id, String descr, int año, int mes, int dias, String estado) {
        super(id, descr, año, mes, dias, estado);
    }
    
    //Metodo para insertar elemento de la pila
    public void push(int id){
        System.out.println("Num. Tarea: "+id);
        System.out.print("Descripcion: ");
        descr = tec.nextLine();//Permite el ingreso de nombre del cliente
        System.out.print("Fecha de vencimiento: ");
        System.out.print("Año: ");
        año = tec.nextInt();//Permite el ingreso de los productos
        System.out.print("Mes: ");
        mes = tec.nextInt();//Permite el ingreso de los productos
        System.out.print("Dia: ");
        dias = tec.nextInt();//Permite el ingreso de los productos

        // Obtén las fechas que deseas comparar
        LocalDate fecha1 = LocalDate.of(año, mes, dias);
        LocalDate fecha2 = LocalDate.now();
    
        do{
            System.out.println("1: Pendiente    2: Complentado    3: Vencido");
            System.out.print("Estado: ");
            int opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    validar = true;
                    estado = "Pendiente";
                    if (fecha1.isBefore(fecha2)) {
                        System.out.println("Fecha anterior a fecha actual, por ende se marcara como vencida");
                        vencido.add(id, new Tarea(id, descr, año, mes, dias, "Vencido"));//Guarda en la pila los datos ingresados
                    }else{
                        pend.add(new Tarea(id, descr, año, mes, dias, estado));
                    }
                    break;
                case 2:
                    validar = true;
                    estado = "Complentado";
                    if (fecha1.isBefore(fecha2)) {
                        System.out.println("Fecha anterior a fecha actual, por ende se marcara como vencida");
                        vencido.add(id, new Tarea(id, descr, año, mes, dias, "Vencido"));//Guarda en la pila los datos ingresados
                    }else{
                        agend.add(id, new Tarea(id, descr, año, mes, dias, estado));//Guarda en la pila los datos ingresados
                    }
                    break;
                case 3:
                    estado = "Vencido";
                    validar = true;
                    vencido.add(id, new Tarea(id, descr, año, mes, dias, estado));//Guarda en la pila los datos ingresados
                    break;
                default:
                    System.out.println("No existe ese estado de tarea ");
                    break;
            }
        }while(validar != true);

        System.out.println("");

    }

    //Muestra los elementos de la pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPilaCompletado(){
        for (Tarea tare : agend) {
            System.out.println("Num. Tarea: "+tare.getId());
            System.out.println("Descripcion: "+tare.getDescr());
            System.out.println("Fecha de vencimiento: "+tare.getAño()+"/"+tare.getMes()+"/"+tare.getDias());
            System.out.println("Estado: "+tare.getEstado());
            System.out.println("");
        }
    }

    //Muestra los elementos de la pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPilaPendiente(){
        for (Tarea tare : pend) {
            System.out.println("Num. Tarea: "+tare.getId());
            System.out.println("Descripcion: "+tare.getDescr());
            System.out.println("Fecha de vencimiento: "+tare.getAño()+"/"+tare.getMes()+"/"+tare.getDias());
            System.out.println("Estado: "+tare.getEstado());
            System.out.println("");
        }
    }

    //Muestra los elementos de la pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPilaVencido(){
        for (Tarea tare : vencido) {
            System.out.println("Num. Tarea: "+tare.getId());
            System.out.println("Descripcion: "+tare.getDescr());
            System.out.println("Fecha de vencimiento: "+tare.getAño()+"/"+tare.getMes()+"/"+tare.getDias());
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

    public void OrdenarPilaCompletado() {
        // Ordena la pila
        agend.sort((elemento1, elemento2) -> Integer.compare(elemento1.getId(), elemento2.getId()));

        // Imprime la pila ordenada
        while (!agend.isEmpty()) {
            System.out.println(agend.pop().getId());
        }
    }
    
    public void OrdenarPilaVencido() {
        // Ordena la pila
        vencido.sort((elemento1, elemento2) -> Integer.compare(elemento1.getId(), elemento2.getId()));

        // Imprime la pila ordenada
        while (!vencido.isEmpty()) {
            System.out.println(vencido.pop().getId());
        }
    }
    
    public void OrdenarColaPendiente(){
        pend = new PriorityQueue<>((elemento1, elemento2) -> Integer.compare(elemento1.getId(), elemento2.getId()));
        // Imprime la cola ordenada
        while (!pend.isEmpty()) {
            System.out.println(pend.poll().getId());
        }
    }
}
