package edd_parcial2_tutoria_gestion_nota_alexanderq;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
/**
 *
 * @author Alexander Quizhpe
 */
public class GestionNotas extends JFrame{
    private JTextField nombreField, notaField;
    private JTextArea resultadoArea;

    private String[] nombresEstudiantes;
    private int[] notasEstudiantes;

    public GestionNotas() {
        super("Gestión de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Campos de texto y etiquetas
        add(new JLabel("Nombre del estudiante:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Nota del estudiante:"));
        notaField = new JTextField();
        add(notaField);

        // Botones
        JButton ingresarBtn = new JButton("Ingresar Nota");
        ingresarBtn.addActionListener(new IngresarNotaListener());
        add(ingresarBtn);

        JButton ordenarBtn = new JButton("Ordenar Notas");
        ordenarBtn.addActionListener(new OrdenarNotasListener());
        add(ordenarBtn);

        JButton buscarBtn = new JButton("Buscar Estudiante");
        buscarBtn.addActionListener(new BuscarEstudianteListener());
        add(buscarBtn);

        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea));

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private class IngresarNotaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombreField.getText();
            String notaText = notaField.getText();

            if (!nombre.isEmpty() && !notaText.isEmpty()) {
                int nota = Integer.parseInt(notaText);

                if (nombresEstudiantes == null) {
                    nombresEstudiantes = new String[]{nombre};
                    notasEstudiantes = new int[]{nota};
                } else {
                    // Añadir nuevos elementos a los arreglos
                    nombresEstudiantes = Arrays.copyOf(nombresEstudiantes, nombresEstudiantes.length + 1);
                    notasEstudiantes = Arrays.copyOf(notasEstudiantes, notasEstudiantes.length + 1);

                    nombresEstudiantes[nombresEstudiantes.length - 1] = nombre;
                    notasEstudiantes[notasEstudiantes.length - 1] = nota;
                }

                mostrarResultado("Nota ingresada para " + nombre);
            } else {
                mostrarResultado("Por favor, ingrese el nombre y la nota del estudiante.");
            }

            // Limpiar campos después de ingresar una nota
            nombreField.setText("");
            notaField.setText("");
        }
    }

    private class OrdenarNotasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nombresEstudiantes != null && nombresEstudiantes.length > 1) {
                ordenarNotasBurbuja();
                mostrarResultado("Notas ordenadas correctamente.");
            } else {
                mostrarResultado("Ingrese al menos dos notas para ordenar.");
            }
        }
    }

    private class BuscarEstudianteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreBuscar = nombreField.getText();

            if (!nombreBuscar.isEmpty() && nombresEstudiantes != null) {
                int indice = buscarEstudiante(nombreBuscar);

                if (indice != -1) {
                    mostrarResultado("Estudiante encontrado: " + nombresEstudiantes[indice] +
                            ", Nota: " + notasEstudiantes[indice]);
                } else {
                    mostrarResultado("Estudiante no encontrado.");
                }
            } else {
                mostrarResultado("Ingrese el nombre del estudiante para buscar.");
            }
        }
    }

    private void ordenarNotasBurbuja() {
        int n = notasEstudiantes.length;
        boolean intercambio;

        do {
            intercambio = false;

            for (int i = 1; i < n; i++) {
                if (notasEstudiantes[i - 1] > notasEstudiantes[i]) {
                    // Intercambiar notas
                    int tempNota = notasEstudiantes[i - 1];
                    notasEstudiantes[i - 1] = notasEstudiantes[i];
                    notasEstudiantes[i] = tempNota;

                    // Intercambiar nombres
                    String tempNombre = nombresEstudiantes[i - 1];
                    nombresEstudiantes[i - 1] = nombresEstudiantes[i];
                    nombresEstudiantes[i] = tempNombre;

                    intercambio = true;

                    // Mostrar visualmente el proceso de ordenación paso a paso
                    mostrarResultado(Arrays.toString(nombresEstudiantes) + "\n" + Arrays.toString(notasEstudiantes));
                }
            }
        } while (intercambio);
    }

    private int buscarEstudiante(String nombreBuscar) {
        for (int i = 0; i < nombresEstudiantes.length; i++) {
            if (nombresEstudiantes[i].equalsIgnoreCase(nombreBuscar)) {
                return i;
            }
        }
        return -1;
    }

    private void mostrarResultado(String mensaje) {
        resultadoArea.append(mensaje + "\n\n");
    }
}
