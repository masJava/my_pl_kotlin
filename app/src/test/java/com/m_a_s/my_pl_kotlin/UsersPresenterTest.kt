package com.m_a_s.my_pl_kotlin

import com.github.terrakok.cicerone.Router
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import com.m_a_s.my_pl_kotlin.mvp.model.GithubUsersRepo
import com.m_a_s.my_pl_kotlin.mvp.model.entity.GithubUser
import com.m_a_s.my_pl_kotlin.mvp.presenter.UsersPresenter

class UsersPresenterTest {


    @Mock
    private lateinit var usersRepo: GithubUsersRepo

    @Mock
    private lateinit var router: Router

    private lateinit var presenter: UsersPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = UsersPresenter(usersRepo, router)
    }

    @Test
    fun presenterBackClick() {
        assertTrue(presenter.backClick())
    }

    @Test
    fun verifyRouterExit() {
        presenter.backClick()
        verify(router, times(1)).exit()
    }

    @Test
    fun firstStartEmptyUsers() {
        assertTrue(presenter.usersListPresenter.users == emptyList<GithubUser>())
    }

    @Test
    fun checkUserAdd_True() {
        `when`(usersRepo.getUsers()).thenReturn(listOf(GithubUser("qwe"), GithubUser("qwerty")))
        presenter.loadData()
        assertNotNull(presenter.usersListPresenter.users)
    }

    @Test
    fun check2UserAdd_True() {
        `when`(usersRepo.getUsers()).thenReturn(listOf(GithubUser("qwe"), GithubUser("qwerty")))
        presenter.loadData()
        assertEquals(2, presenter.usersListPresenter.users.count())
    }

}