
package edd_parcial2_practica2_metodo.de.ordenamiento_alexanderq;

/**
 *
 * @author ESPE
 */
public class StringOnlyException extends Exception{
    public StringOnlyException(String message) {
        super(message);
    }

    public static void validateString(String input) throws StringOnlyException {
        if (!input.matches("^[a-zA-Z]+$")) {
            throw new StringOnlyException("Solo se permiten cadenas de texto");
        }
    }
}