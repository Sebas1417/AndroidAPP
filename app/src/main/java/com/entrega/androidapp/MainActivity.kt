package com.entrega.androidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.entrega.androidapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var navegation : NavigationView
    private lateinit var PerfilFragment: perfilFragment
    private lateinit var FotosFragment: fotosFragment
    private lateinit var VideoFragment: videoFragment
    private lateinit var WebFragment: webFragment
    private lateinit var JuegoFragment: juegoFragment

    private val mOnNavMenu = NavigationView.OnNavigationItemSelectedListener { item ->

        val currentFragment = supportFragmentManager.findFragmentById(R.id.frameContainer)

        when (item.itemId){
            R.id.perfilbtn ->{
                supportFragmentManager.beginTransaction().apply {
                    hideAllFragments()
                    show(PerfilFragment)
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.fotosbtn ->{
                supportFragmentManager.beginTransaction().apply {
                    hideAllFragments()
                    show(FotosFragment)
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.videobtn ->{
                supportFragmentManager.beginTransaction().apply {
                    hideAllFragments()
                    show(VideoFragment)
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.webxbtn ->{
                supportFragmentManager.beginTransaction().apply {
                    hideAllFragments()
                    show(WebFragment)
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.juegobtn ->{
                supportFragmentManager.beginTransaction().apply {
                    hideAllFragments()
                    show(JuegoFragment)
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    private fun hideAllFragments() {
        supportFragmentManager.beginTransaction().apply {
            hide(PerfilFragment)
            hide(FotosFragment)
            hide(VideoFragment)
            hide(WebFragment)
            hide(JuegoFragment)
            commit()
        }
    }

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navegation = findViewById(R.id.navigationView)
        navegation.setNavigationItemSelectedListener(mOnNavMenu)

        PerfilFragment = perfilFragment.newInstance("param1", "param2")
        FotosFragment = fotosFragment.newInstance("param1", "param2")
        VideoFragment = videoFragment.newInstance("param1", "param2")
        WebFragment = webFragment.newInstance("param1", "param2")
        JuegoFragment = juegoFragment.newInstance("param1", "param2")

        supportFragmentManager.beginTransaction().apply {
            add(R.id.frameContainer, PerfilFragment, "perfilFragment")
            add(R.id.frameContainer, FotosFragment, "fotosFragment")
            add(R.id.frameContainer, VideoFragment, "videoFragment")
            add(R.id.frameContainer, WebFragment, "webFragment")
            add(R.id.frameContainer, JuegoFragment, "juegoFragment")
            hideAllFragments()
            show(PerfilFragment)
            commit()
        }
    }
}

