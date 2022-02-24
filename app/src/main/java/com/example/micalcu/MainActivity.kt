package com.example.micalcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.roundToLong
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.lacalcu.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

private val TAG = "MainActivity"
private val TEXT ="TEXT_CONTENT"
private val TEXT2 = "TEXT_CONTENT2"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lacalcu)

        buttonuno.setOnClickListener {
            Operacion.text = ImprimirOp("1")
        }

        buttondos.setOnClickListener {
            Operacion.text = ImprimirOp("2")
        }
        buttontres.setOnClickListener {
            Operacion.text = ImprimirOp("3")
        }
        buttoncuatro.setOnClickListener {
            Operacion.text = ImprimirOp("4")
        }
        buttoncinco.setOnClickListener {
            Operacion.text = ImprimirOp("5")
        }
        buttonsix.setOnClickListener {
            Operacion.text = ImprimirOp("6")
        }
        buttonsiete.setOnClickListener {
            Operacion.text = ImprimirOp("7")
        }
        buttonocho.setOnClickListener {
            Operacion.text = ImprimirOp("8")
        }
        buttonnueve.setOnClickListener {
            Operacion.text = ImprimirOp("9")
        }
        buttoncero.setOnClickListener {
            Operacion.text = ImprimirOp("0")
        }
        buttonpunto.setOnClickListener {
            Operacion.text = ImprimirOp(".")
        }

        //Operaciones
        buttonmas.setOnClickListener {
            Operacion.text = ImprimirOp("+")
        }
        buttonminus.setOnClickListener {
            Operacion.text = ImprimirOp("-")
        }
        buttonpor.setOnClickListener {
            Operacion.text = ImprimirOp("+")
        }
        buttonpor.setOnClickListener {
            Operacion.text = ImprimirOp("×")
        }
        buttondivi.setOnClickListener {
            Operacion.text = ImprimirOp("÷")
        }

        //Igual
        buttonequal.setOnClickListener {
            Respuesta()
            //Operacion.text =""
        }

        //Borrar
        buttonborrar.setOnClickListener {
            Operacion.text = ""
            Resultado.text = ""
        }

    }

    private fun ImprimirOp(Valor: String): String {
        return "${Operacion.text}$Valor"
    }
    private fun CambiarSimbolo(): String {
        var digito = Operacion.text.replace(Regex("÷"), "/")
        digito = digito.replace(Regex("×"), "*")
        return digito
    }

    private fun Respuesta() {
        try {
            val operation = CambiarSimbolo()
            val ans = Expression(operation).calculate()
            if (ans.isNaN()) {
                Resultado.text = "Error"
            } else {
                Resultado.text = DecimalFormat("0.######").format(ans).toString()
            }
        } catch (e: Exception) {
            Resultado.text = "Error"
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        Resultado?.text = savedInstanceState.getString(TEXT, "")
        Operacion?.text = savedInstanceState.getString(TEXT2, "")
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onPause")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, Resultado.text.toString())
        outState.putString(TEXT2, Operacion.text.toString())

    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

}