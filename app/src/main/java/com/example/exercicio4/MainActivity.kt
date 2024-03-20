package com.example.exercicio4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

fun calculaImc(altura: Double, peso : Double) : Double{
    var imc = peso / (altura * altura)

    imc *= 10000

    return imc
}

fun analisaIMC(imc: Double): String? {

    var message : String? = null

    if (imc < 18.5) {
        message = "Abaixo do peso"
    } else if (imc >= 18.5 && imc <= 24.9) {
        message = "Peso normal"
    } else if (imc >= 25 && imc <= 29.9) {
        message = "Acima do peso"
    } else if (imc >= 30) {
        message = "Obeso"
    }
    return message
}

class MainActivity : AppCompatActivity() {

    lateinit var edtPeso: TextView
    lateinit var edtAltura: TextView
    lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPeso = findViewById(R.id.edt_peso)
        edtAltura = findViewById(R.id.edt_altura)
        btnCalcular = findViewById(R.id.btn_calcular)

        btnCalcular.setOnClickListener(View.OnClickListener {
            val peso : String = edtPeso.text.toString()
            val altura : String = edtAltura.text.toString()

            val imcFinal : String = String.format("%.2f", calculaImc(altura.toDouble(), peso.toDouble()))
            val message : String? = analisaIMC(imcFinal.toDouble())

            Toast.makeText(this, "Seu IMC: $imcFinal. Sua Condição: $message", Toast.LENGTH_SHORT).show()

        })
    }
}

