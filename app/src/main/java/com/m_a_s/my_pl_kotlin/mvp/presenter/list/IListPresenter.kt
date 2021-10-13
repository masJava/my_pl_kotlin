package com.m_a_s.my_pl_kotlin.mvp.presenter.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}