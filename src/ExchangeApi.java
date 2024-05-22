import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeApi {
    private String EXCHANGE_URI = "https://v6.exchangerate-api.com/v6/$API_KEY$/latest/$CURRENCY$";
    private final String API_KEY = ""; // Ingresar la clave de la API

    public ExchangeApi() {
        if (API_KEY.isEmpty()) {
            System.out.println(Mensajes.MENSAJE_CLAVE_API_ERROR);
            System.exit(0);
        }
        this.EXCHANGE_URI = this.EXCHANGE_URI.replace("$API_KEY$", API_KEY);
    }

    /**
     * Obtiene los datos de la API de conversión de monedas
     * @return JsonObject con los datos de la API
     * @throws IOException
     */
    private JsonObject obtenerDatosExchange() throws IOException {
        URL url = new URL(EXCHANGE_URI);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        return jsonobj;
    }

    /**
     * Ejecuta la conversión de una moneda a otra
     * @param currencyFrom moneda de origen
     * @param currencyTo moneda de destino
     * @return valor que se debe multiplicar a la moneda de origen para obtener la moneda de destino
     */
    public double ejecutarConversion(String currencyFrom, String currencyTo) {
        this.EXCHANGE_URI = this.EXCHANGE_URI.replace("$CURRENCY$", currencyFrom);
        try {
            JsonObject exchangeData = obtenerDatosExchange();
            return exchangeData.get("conversion_rates").getAsJsonObject().get(currencyTo).getAsDouble();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(Mensajes.MENSAJE_ERROR_API);
            return 0;
        }
    }

}
