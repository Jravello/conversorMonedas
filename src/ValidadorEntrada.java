import java.util.List;

public class ValidadorEntrada {
    public List<Integer> valoresPermitidos = List.of(1, 2, 3, 4, 5, 6, 9, 0);
    public List<String> monedasPermitidas = List.of("ARS", "BOB", "BRL", "CLP", "COP", "USD", "REINICIAR", "SALIR");
    public Integer inputValueInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Double inputValueDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Valida si el valor ingresado es un número entero y si está dentro de los valores permitidos
     * @param value valor a validar
     * @return valor validado o null si no es válido
     */
    public Integer validar (String value) {
        if (value.equals("REINICIAR") || value.equals("9")) {
            return 9;
        }

        if (value.equals("SALIR") || value.equals("0")) {
            return 0;
        }

        Integer valor = inputValueInteger(value); // Se intenta convertir el valor a un número entero
        if (valor == null) {
            if (monedasPermitidas.contains(value)) { // Si el valor es una moneda permitida

                return monedasPermitidas.indexOf(value) + 1; // Se retorna el índice de la moneda + 1 para que coincida con los valores permitidos
            } else {
                return null;
            }
        } else {
            return valoresPermitidos.contains(valor) ? valor : null;
        }
    }


}
