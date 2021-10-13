package com.m_a_s.my_pl_kotlin.mvp.model

import com.m_a_s.my_pl_kotlin.mvp.model.entity.GithubUser

class GithubUsersRepo {
    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): List<GithubUser> {
        return users
    }
}