package com.example.practica5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btn0 = findViewById<Button>(R.id.btn0)
        //Estas variables son botones
        val btnPunto = findViewById<Button>(R.id.btnPunto)
        val btnMas = findViewById<Button>(R.id.btnMas)
        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnPor = findViewById<Button>(R.id.btnPor)
        val btnDivision = findViewById<Button>(R.id.btnDivision)
        val btnIgual = findViewById<Button>(R.id.btnIgual)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        //Estas variables son cajas de texto
        val txtOperacion = findViewById<EditText>(R.id.txtOperacion)
        val txtResultado = findViewById<EditText>(R.id.txtResultado)
        //Estas variables son variables globales
        var numero1 = ""
        var numero2 = ""
        var tipo = ""

        btn1.setOnClickListener {
            txtResultado.append("1")
        }
        btn2.setOnClickListener {
            txtResultado.append("2")
        }
        btn3.setOnClickListener {
            txtResultado.append("3")
        }
        btn4.setOnClickListener {
            txtResultado.append("4")
        }
        btn5.setOnClickListener {
            txtResultado.append("5")
        }
        btn6.setOnClickListener {
            txtResultado.append("6")
        }
        btn7.setOnClickListener {
            txtResultado.append("7")
        }
        btn8.setOnClickListener {
            txtResultado.append("8")
        }
        btn9.setOnClickListener {
            txtResultado.append("9")
        }
        btn0.setOnClickListener {
            txtResultado.append("0")
        }
        btnPunto.setOnClickListener {
            txtResultado.append(".")
        }
        btnMas.setOnClickListener {
            if (numero1.toString() == "") {
                tipo = "suma"
                numero1 =txtResultado.text.toString()
                txtOperacion.setText("$numero1 + ")
                txtResultado.setText("")
            }else{
                numero2 = txtResultado.text.toString()
                val resF = Calcular(numero1,numero2,tipo)
                txtResultado.setText(resF)
                numero1 = resF
                txtOperacion.setText("")
                txtOperacion.append("$numero1 + ")
                numero2 = ""
                txtResultado.setText("")
                tipo = "suma"
            }
        }
        btnMenos.setOnClickListener {
            if (numero1.toString() == "") {
                tipo = "resta"
                numero1 =txtResultado.text.toString()
                txtOperacion.setText("$numero1 - ")
                txtResultado.setText("")
            }else{
                numero2 = txtResultado.text.toString()
                val resF = Calcular(numero1,numero2,tipo)
                txtResultado.setText(resF)
                numero1 = resF
                txtOperacion.setText("")
                txtOperacion.append("$numero1 - ")
                numero2 = ""
                txtResultado.setText("")
                tipo = "resta"
            }
        }
        btnPor.setOnClickListener {
            if (numero1.toString() == ""){
                tipo = "multiplicacion"
                numero1 = txtResultado.text.toString()
                txtOperacion.setText("$numero1 * ")
                txtResultado.setText("")
            }else{
                numero2 = txtResultado.text.toString()
                val resF = Calcular(numero1,numero2,tipo)
                txtResultado.setText(resF)
                numero1 = resF
                txtOperacion.setText("")
                txtOperacion.append("$numero1 * ")
                numero2 = ""
                txtResultado.setText("")
                tipo = "multiplicacion"
            }
        }
        btnDivision.setOnClickListener {
            if (numero1.toString() == ""){
                tipo = "division"
                numero1 = txtResultado.text.toString()
                txtOperacion.setText("$numero1 / ")
                txtResultado.setText("")
            }else{
                numero2 = txtResultado.text.toString()
                val resF = Calcular(numero1,numero2,tipo)
                txtResultado.setText(resF)
                numero1 = resF
                txtOperacion.setText("")
                txtOperacion.append("$numero1 / ")
                numero2 = ""
                txtResultado.setText("")
                tipo = "division"
            }
        }
        btnIgual.setOnClickListener {
            numero2 = txtResultado.text.toString()
            txtOperacion.append(numero2)
            val resF = Calcular(numero1,numero2,tipo)
            txtResultado.setText(resF)
            numero1 = ""
            numero2 = ""
            tipo = ""
            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false
            btn0.isEnabled = false
            btnPor.isEnabled = false
            btnMenos.isEnabled = false
            btnMas.isEnabled = false
            btnPunto.isEnabled = false
            btnDivision.isEnabled = false
            btnIgual.isEnabled = false
        }
        btnBorrar.setOnClickListener {
            txtResultado.setText("")
            txtOperacion.setText("")
            numero1 = ""
            numero2 = ""
            tipo = ""
            btn1.isEnabled = true
            btn2.isEnabled = true
            btn3.isEnabled = true
            btn4.isEnabled = true
            btn5.isEnabled = true
            btn6.isEnabled = true
            btn7.isEnabled = true
            btn8.isEnabled = true
            btn9.isEnabled = true
            btn0.isEnabled = true
            btnPor.isEnabled = true
            btnMenos.isEnabled = true
            btnMas.isEnabled = true
            btnPunto.isEnabled = true
            btnDivision.isEnabled = true
            btnIgual.isEnabled = true
        }
    }
    fun Calcular(numero1:String,numero2:String,tipo:String):String{
        if (tipo == "suma"){
            val num1 = numero1.toDouble()
            val num2 = numero2.toDouble()
            val res = num1 + num2
            return res.toString()
        }
        if (tipo == "resta"){
            val num1 = numero1.toDouble()
            val num2 = numero2.toDouble()
            val res = num1 - num2
            return res.toString()
            }
        if (tipo == "multiplicacion"){
            val num1 = numero1.toDouble()
            val num2 = numero2.toDouble()
            val res = num1 * num2
            return res.toString()
        }
        if (tipo == "division"){
            val num1 = numero1.toDouble()
            val num2 = numero2.toDouble()
            val res = num1 / num2
            return res.toString()
        }
        return ""
    }
}



