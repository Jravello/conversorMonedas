import java.util.Scanner;

public class Conversor {
    public void iniciar() {
        System.out.println(Mensajes.MENSAJE_TITULO);
        System.out.println(Mensajes.SEPARADOR);
        System.out.println(Mensajes.MENSAJE_TIPOS_CONVERSION_MONEDA);
        System.out.println(Mensajes.SEPARADOR);
        System.out.println(Mensajes.MENSAJE_MONEDA_ORIGEN);

        Scanner scanner = new Scanner(System.in);
        String monedaOrigen = scanner.nextLine();

        ValidadorEntrada validadorEntrada = new ValidadorEntrada();
        Integer monedaOrigenInt = validadorEntrada.validar(monedaOrigen.toUpperCase().trim()); // Se convierte a mayúsculas y se eliminan los espacios en blanco

        if (monedaOrigenInt == null) {
            System.out.println(Mensajes.MENSAJE_ERROR_MONEDA);
            iniciar();
        }

        if (monedaOrigenInt.equals(9)) {
            System.out.println(Mensajes.SEPARADOR);
            iniciar();
        }

        if (monedaOrigenInt.equals(0)) {
            System.out.println(Mensajes.SEPARADOR);
            System.out.println(Mensajes.MENSAJE_SALIR);
            System.out.println(Mensajes.SEPARADOR);
            System.exit(0);
        }

        System.out.println(Mensajes.MENSAJE_DINERO_CONVERSION);
        String dinero = scanner.nextLine();
        Double dineroDouble = validadorEntrada.inputValueDouble(dinero);

        if (dineroDouble == null) {
            System.out.println(Mensajes.MENSAJE_ERROR_DINERO);
            iniciar();
        }


        System.out.println(Mensajes.MENSAJE_MONEDA_DESTINO);
        String monedaDestino = scanner.nextLine();
        Integer monedaDestinoInt = validadorEntrada.validar(monedaDestino.toUpperCase().trim()); // Se convierte a mayúsculas y se eliminan los espacios en blanco

        if (monedaDestinoInt == null) {
            System.out.println(Mensajes.MENSAJE_ERROR_MONEDA);
            iniciar();
        }

        if (monedaDestinoInt.equals(9)) {
            System.out.println(Mensajes.SEPARADOR);
            iniciar();
        }

        if (monedaDestinoInt.equals(0)) {
            System.out.println(Mensajes.SEPARADOR);
            System.out.println(Mensajes.MENSAJE_SALIR);
            System.out.println(Mensajes.SEPARADOR);
            System.exit(0);
        }

        if (monedaOrigenInt.equals(monedaDestinoInt)) {
            System.out.println(Mensajes.SEPARADOR);
            System.out.println(Mensajes.MENSAJE_MONEDAS_IGUALES);
            System.out.println(Mensajes.SEPARADOR);
            iniciar();
        }

        ExchangeApi exchangeApi = new ExchangeApi();
        String monedaOrigenStr = validadorEntrada.monedasPermitidas.get(monedaOrigenInt - 1);
        String monedaDestinoStr = validadorEntrada.monedasPermitidas.get(monedaDestinoInt - 1);
        Double conversion = exchangeApi.ejecutarConversion(monedaOrigenStr, monedaDestinoStr);
        double resultado = dineroDouble * conversion;

        System.out.println(Mensajes.SEPARADOR);
        System.out.println(Mensajes.MENSAJE_RESULTADO);
        System.out.println("1 " + monedaOrigenStr + " = " + conversion + " " + monedaDestinoStr);
        System.out.println(dineroDouble + " " + monedaOrigenStr + " = " + resultado + " " + monedaDestinoStr);
        System.out.println(Mensajes.SEPARADOR);

        iniciar();
    }
}
