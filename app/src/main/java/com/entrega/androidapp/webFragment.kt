package com.entrega.androidapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class webFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var webView: WebView
    private lateinit var urlInput: EditText
    private lateinit var loadButton: Button

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        webView = view.findViewById(R.id.webView)
        urlInput = view.findViewById(R.id.edit_text1)
        loadButton = view.findViewById(R.id.button1)

        webView.webViewClient = WebViewClient()

        loadButton.setOnClickListener {
            var url = urlInput.text.toString()
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url
            }
            webView.loadUrl(url)

            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            webFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}