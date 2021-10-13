package com.m_a_s.my_pl_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.m_a_s.my_pl_kotlin.mvp.navigation.IScreens
import com.m_a_s.my_pl_kotlin.mvp.view.MainView

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }

}