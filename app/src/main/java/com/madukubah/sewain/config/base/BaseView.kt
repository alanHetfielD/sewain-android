package com.madukubah.sewain.config.base

interface BaseView<T>
{
    fun setPresenter( presenter : T )
    fun showLoading()
    fun hideLoading()
}