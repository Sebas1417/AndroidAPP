package com.entrega.androidapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




class videoFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var videoView: VideoView
    private val VIDEO_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_video, container, false)

        videoView = view.findViewById<VideoView>(R.id.video_view)
        val button1 = view.findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            openGalleryForVideo()
        }

        return view
    }

    private fun openGalleryForVideo() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "video/*"
        startActivityForResult(intent, VIDEO_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == VIDEO_REQUEST_CODE) {
            val videoUri = data?.data
            videoView.setVideoURI(videoUri)

            val mediaController = MediaController(context)
            mediaController.setMediaPlayer(videoView)
            videoView.setMediaController(mediaController)

            videoView.start()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            videoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
