## Conversor de moneda

Este proyecto es un conversor de moneda,
el cual permite convertir de una moneda a otra,
en este caso de las siguientes monedas:

| Identificador |       Monedas        | Abreviatura |
|:-------------:|:--------------------:|:-----------:|
|       1       |    Peso argentino    |     ARS     |
|       2       | Boliviano boliviano  |     BOB     |
|       3       |    Real brasileño    |     BRL     |
|       4       |     Peso chileno     |     CLP     |
|       5       |   Peso colombiano    |     COP     |
|       6       | Dólar estadounidense |     USD     |

Para poder realizar la conversión de moneda,
se debe seleccionar la moneda de origen ,
ingresar el monto a convertir y la moneda de destino.

Para cambio en el flujo

| Identificador |  Accion   | Abreviatura |
|:-------------:|:---------:|:-----------:|
|       9       | REINICIAR |  REINICIAR  |
|       0       |   SALIR   |    SALIR    |

## Tecnologías utilizadas

API de [ExchangeRate-API](https://www.exchangerate-api.com/)
para obtener las tasas de cambio de las monedas.

GSON para convertir el JSON obtenido de la API a objetos de Java.

## Ejecución

Antes de ejecutar se debe añadir la `API KEY` en el archivo `ExchangeApi.java` ubicado en la carpeta `src`.

Para ejecutar el proyecto se debe correr el archivo `Main.java` ubicado en la carpeta `src`.