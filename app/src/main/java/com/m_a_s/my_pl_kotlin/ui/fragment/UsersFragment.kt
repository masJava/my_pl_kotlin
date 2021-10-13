package com.m_a_s.my_pl_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.m_a_s.my_pl_kotlin.databinding.FragmentUsersBinding
import com.m_a_s.my_pl_kotlin.mvp.model.GithubUsersRepo
import com.m_a_s.my_pl_kotlin.mvp.presenter.UsersPresenter
import com.m_a_s.my_pl_kotlin.mvp.view.UsersView
import com.m_a_s.my_pl_kotlin.ui.App
import com.m_a_s.my_pl_kotlin.ui.BackClickListener
import com.m_a_s.my_pl_kotlin.ui.adapter.UsersRVAdapter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackClickListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter by moxyPresenter {
        UsersPresenter(GithubUsersRepo(), App.instance.router)
    }

    private var vb: FragmentUsersBinding? = null
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()

}