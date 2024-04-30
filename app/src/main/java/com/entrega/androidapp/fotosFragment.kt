package com.entrega.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class fotosFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fotos, container, false)

        // Crear una lista de imágenes y descripciones
        val imagenes = listOf(R.mipmap.wall2, R.mipmap.wall3, R.mipmap.wall4, R.mipmap.wall5, R.mipmap.wall6, R.mipmap.wall7,
            R.mipmap.wall8, R.mipmap.wall9, R.mipmap.wall10, R.mipmap.wall1, R.mipmap.wall11, R.mipmap.wall12)
        val descripciones = listOf("Logo del Politecnico Grancolombiano", "Bandera de Colombia", "Logo de Android Studio",
            "Campus del Politecnico Grancolombiano", "Aplicacion de WhatsApp", "Red Social Facebook", "Imagen de una Galaxia",
            "La ciudad de Bogota", "Orquesta dando su presentación", "Wallpaper para poner en tu escritorio",
            "Wallpaper Del Hombre Araña", "Logotipo de la marca de celulares Apple")

        viewManager = LinearLayoutManager(context)
        viewAdapter = MiAdapter(imagenes, descripciones)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fotosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
class MiAdapter(private val imagenes: List<Int>, private val descripciones: List<String>) :
    RecyclerView.Adapter<MiAdapter.MiViewHolder>() {

    inner class MiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.mi_imagen)
        val descripcion: TextView = itemView.findViewById(R.id.mi_descripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_mi_item, parent, false)
        return MiViewHolder(view)
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.imagen.setImageResource(imagenes[position])
        holder.descripcion.text = descripciones[position]

        holder.itemView.setOnClickListener {
            // Aquí puedes manejar el evento de clic en un elemento de la lista
            Toast.makeText(holder.itemView.context, descripciones[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = imagenes.size
}

