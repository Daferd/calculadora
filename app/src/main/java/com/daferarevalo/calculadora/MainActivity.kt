package com.daferarevalo.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    private var band: Int = 0
    private var result: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unoButton.setOnClickListener { numeroPresionado("1") }
        dosButton.setOnClickListener { numeroPresionado("2") }
        tresButton.setOnClickListener { numeroPresionado("3") }
        cuatroButton.setOnClickListener { numeroPresionado("4") }
        cincoButton.setOnClickListener { numeroPresionado("5") }
        seisButton.setOnClickListener { numeroPresionado("6") }
        sieteButton.setOnClickListener { numeroPresionado("7") }
        ochoButton.setOnClickListener { numeroPresionado("8") }
        nueveButton.setOnClickListener { numeroPresionado("9") }
        ceroButton.setOnClickListener { numeroPresionado("0") }
        puntoButton.setOnClickListener { numeroPresionado(".") }
        masButton.setOnClickListener { operacionPresionada(SUMA) }
        menosButton.setOnClickListener { operacionPresionada(RESTA) }
        dividirButton.setOnClickListener { operacionPresionada(DIVISION) }
        multiplicarButton.setOnClickListener { operacionPresionada(MULTIPLICACION) }

        borrarButton.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultadoTextView.text = ""
            operacion = NO_OPERACION
        }

        igualButton.setOnClickListener {

            this.result = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0.0
            }

            resultadoTextView.text = result.toString()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun numeroPresionado(digito: String) {

        resultadoTextView.text = "${resultadoTextView.text}$digito"

        if (operacion == NO_OPERACION) {
            num1 = resultadoTextView.text.toString().toDouble()
            result = resultadoTextView.text.toString().toDouble()

        } else {
            num1 = result
            num2 = resultadoTextView.text.toString().toDouble()
        }

    }


    private fun operacionPresionada(operacion: Int){
        this.operacion=operacion
        resultadoTextView.text = ""
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }
}




