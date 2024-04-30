package com.entrega.androidapp


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class perfilFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var btnImage : Button
    lateinit var imagenVer: ImageView
    var miImagenUri: Uri? = null

    val pickMedia = registerForActivityResult(PickVisualMedia()){ uri ->
        if(uri!=null){
            miImagenUri = uri
            imagenVer.setImageURI(uri)
        }
    }

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
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)
        btnImage = view.findViewById(R.id.btnImage)
        imagenVer = view.findViewById(R.id.imagenVer)
        btnImage.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            perfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
