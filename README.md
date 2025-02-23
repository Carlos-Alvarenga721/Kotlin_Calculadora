# Calculadora de Kilogramos a Libras

Este proyecto de ejemplo es una aplicación que convierte kilogramos a libras utilizando el factor de conversión **1 Kg = 2.20462 Lb**.

El objetivo principal de esta pequeña aplicación es mostrar como obtener una entrada del usuario por medio de cajas de texto, utilizar el contenido y mostrar mensajes al usuario dependiendo la necesidad.

Se utilizo un constraint layout para la interfaz donde podemos encontrar:

- TextView (LblQtyKilograms) como label para kilogramos.
- TextView (LblQtyPounds) como label libras.
- EditText (TxtQtyKilograms) como input numérico (incluyendo negativos para fines de validaciones) para el input de los kilogramos.
- EditText (TxtQtyPounds) para mostrar el resultado de la conversión.
- Button (BtnConvert) para realizar la conversión.

En el archivo MainActivity.ky se escribieron dos métodos privados para completar la funcionalidad de la aplicación.

**isValidInput(inputText: String?)** se implementa para validar la entrada de texto desde el TextView de los kilogramos, comprueba que la caja de texto no este vacía y si no es el caso, convierte el texto ingresado a Float para validar si es menor que CERO, en ambos casos un mensaje es desplegado al usuario mostrando que existe un inconveniente con la entrada y no se realiza el calculo.

**convertKgToLb(kilograms: Float)** se encarga de convertir la cantidad de kilogramos pasada por parámetro y devolver la cantidad de libras según el factor de conversión.