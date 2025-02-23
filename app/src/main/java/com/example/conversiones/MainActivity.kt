package com.example.conversiones

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

private const val s = "peracion no valida"

class MainActivity : AppCompatActivity() {
    private var botonSeleccionado: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)



        var opcion: String = "Seleccione algo por favor"

        val btnSuma: Button = findViewById(R.id.BtnSuma)
        val BtnResta: Button = findViewById(R.id.BtnResta)
        val BtnDivision: Button = findViewById(R.id.BtnDivision)
        val BtnMultiplicacion: Button = findViewById(R.id.BtnMultiplicacion)

        val BtnCalcular: Button = findViewById(R.id.BtnCalcular)


        val txtnum1: TextView = findViewById(R.id.Txtnum1)
        val txtnum2: TextView = findViewById(R.id.Txtnum2)
        var result : TextView = findViewById(R.id.LblResultado)
        var signo : TextView = findViewById(R.id.lblSigno)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSuma.setOnClickListener {
            opcion = "+"
            signo.text = opcion
            cambiarColorBoton(btnSuma)
        }

        BtnResta.setOnClickListener {
            opcion = "-"
            signo.text = opcion
            cambiarColorBoton(BtnResta)

        }

        BtnDivision.setOnClickListener {
            opcion = "/"
            signo.text = opcion
            cambiarColorBoton(BtnDivision)

        }

        BtnMultiplicacion.setOnClickListener {
            opcion = "*"
            signo.text = opcion
            cambiarColorBoton(BtnMultiplicacion)

        }

        BtnCalcular.setOnClickListener {
            val qtynum1: String = txtnum1.getText().toString()
            val qtynum2: String = txtnum2.getText().toString()

            if (isValidInput(qtynum1) && isValidInput(qtynum2)) {
                val num1: Float = qtynum1.toFloat()
                val num2: Float = qtynum2.toFloat()
                var resultado: Float = CalcularOperacion(num1, num2, opcion)

                if (resultado.isNaN()) {
                    return@setOnClickListener
                }
                signo.text.toString()
                result.text = String.format(Locale.getDefault(), "%.2f %s %.2f = %.2f", num1, opcion, num2, resultado)

            }
        }
    }

    private fun isValidInput(inputText: String?): Boolean {

        if(inputText.isNullOrEmpty()){
            val toast = Toast.makeText(
                this,
                "No pusiste nada rey, necesito un numero",
                Toast.LENGTH_SHORT)
            toast.show()

            return false
        }

        return true
    }

    private fun CalcularOperacion(num1: Float, num2: Float, opcion: String): Float {
        return when(opcion) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 != 0f) {
                    num1 / num2
                } else {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                    return Float.NaN
                }
            }
            else -> {
                Toast.makeText(this, "Operación no válida", Toast.LENGTH_SHORT).show()
                return Float.NaN //Esto lo saque de Gemini, no entendia porque me daba error
                //asi que me dio de solucion que al when, le pusiera un else para solucionarlo.
            }
        }
    }

    private fun cambiarColorBoton(boton: Button) {
        //Esto tambien lo saque de internet, es que se veia feo mi interfaz XD, entonces mejor le meti colores
        botonSeleccionado?.setBackgroundColor(getColor(R.color.colorBotonNormal))
        boton.setBackgroundColor(getColor(R.color.colorBotonSeleccionado))
        botonSeleccionado = boton
    }


}