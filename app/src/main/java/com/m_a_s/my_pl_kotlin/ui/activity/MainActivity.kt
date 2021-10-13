package com.m_a_s.my_pl_kotlin.ui.activity

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import com.m_a_s.my_pl_kotlin.R
import com.m_a_s.my_pl_kotlin.databinding.ActivityMainBinding
import com.m_a_s.my_pl_kotlin.mvp.presenter.MainPresenter
import com.m_a_s.my_pl_kotlin.mvp.view.MainView
import com.m_a_s.my_pl_kotlin.ui.App
import com.m_a_s.my_pl_kotlin.ui.BackClickListener
import com.m_a_s.my_pl_kotlin.ui.adapter.UsersRVAdapter
import com.m_a_s.my_pl_kotlin.ui.navigation.AndroidScreens

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }

    private var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackClickListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

}