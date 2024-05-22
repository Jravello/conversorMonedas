public class Mensajes {
    public static final String SEPARADOR = "----------------------------------------";
    public static final String MENSAJE_TITULO = "Conversor de monedas";
    public static final String MENSAJE_MONEDA_ORIGEN = "Introduce la moneda de origen (1-6) o el código de la moneda";
    public static final String MENSAJE_DINERO_CONVERSION = "Introduce la cantidad de dinero a convertir";
    public static final String MENSAJE_MONEDA_DESTINO = "Introduce la moneda de destino (1-6) o el código de la moneda";
    public static final String MENSAJE_TIPOS_CONVERSION_MONEDA = """
        [1] [ARS] - Peso argentino
        [2] [BOB] - Boliviano boliviano
        [3] [BRL] - Real brasileño
        [4] [CLP] - Peso chileno
        [5] [COP] - Peso colombiano
        [6] [USD] - Dólar estadounidense
        [9] [REINICIAR] - Reiniciar
    """;

    public static final String MENSAJE_ERROR_MONEDA = "La moneda ingresada no es válida";
    public static final String MENSAJE_ERROR_DINERO = "El valor ingresado no es válido";

    public static final String MENSAJE_ERROR_API = "Error al obtener los datos de la API";

    public static final String MENSAJE_RESULTADO = "Resultado de la conversión";

    public static final String MENSAJE_SALIR = "¡Hasta luego!";

    public static final String MENSAJE_MONEDAS_IGUALES = "Las monedas de origen y destino no pueden ser iguales";

    public static final String MENSAJE_CLAVE_API_ERROR = "Por favor, ingrese la clave de la API en la clase ExchangeApi";
}
