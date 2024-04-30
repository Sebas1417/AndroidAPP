package com.entrega.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Random


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class juegoFragment : Fragment() {
    private var currentNumber: Int = 0
    private val random = Random()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_juego, container, false)

        currentNumber = random.nextInt(100) + 1

        val numberTextView: TextView = view.findViewById(R.id.numberTextView)
        numberTextView.text = currentNumber.toString()

        val lowerButton: Button = view.findViewById(R.id.lowerButton)
        lowerButton.setOnClickListener {
            val nextNumber = random.nextInt(100) + 1
            if (nextNumber < currentNumber) {
                Toast.makeText(context, "¡Correcto!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Incorrecto. El número es mayor.", Toast.LENGTH_SHORT).show()
            }
            currentNumber = nextNumber
            numberTextView.text = currentNumber.toString()
        }

        val higherButton: Button = view.findViewById(R.id.higherButton)
        higherButton.setOnClickListener {
            val nextNumber = random.nextInt(100) + 1
            if (nextNumber > currentNumber) {
                Toast.makeText(context, "¡Correcto!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Incorrecto. El número es menor.", Toast.LENGTH_SHORT).show()
            }
            currentNumber = nextNumber
            numberTextView.text = currentNumber.toString()
        }

        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            juegoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}