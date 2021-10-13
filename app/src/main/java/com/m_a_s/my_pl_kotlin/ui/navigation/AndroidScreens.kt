package com.m_a_s.my_pl_kotlin.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.m_a_s.my_pl_kotlin.mvp.navigation.IScreens
import com.m_a_s.my_pl_kotlin.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}