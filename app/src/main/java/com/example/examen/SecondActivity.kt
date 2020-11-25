package com.example.examen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val VAR ="Clave"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val texto = intent.getStringExtra(VAR)
        val palabras = texto.toString().replace(" ", "\n")
        val palabrasLista = mutableListOf(palabras.split(" "))

        textView.text = palabras

        boton1.setOnClickListener {
            var tam: Int
            palabrasLista.forEach {
                tam = it.size
                textView.text = "$palabras $tam"
            }
            //textView.text = "$palabras ${palabrasLista.forEach { println("$it.length")}}"
        }

        boton2.setOnClickListener {
            val listaOrdenada = palabrasLista.sortedByDescending {
                it.size
            }.toString()
            textView.text = listaOrdenada
        }

        boton3.setOnClickListener {
            /*palabrasLista.forEach {
                if (it.size > editText2.text)
                    //textView.text = palabrasLista.toString()
            }*/
            // Necesito comparar el tamaño de cada palabra de la lista con el número que hay en el edit text
        }

    }
}