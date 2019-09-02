package com.wy.mvp


/* 名称: GitHubApp.com.wy.mvp.mvps
  * 用户: _VIEW
  * 时间: 2019/9/2,16:48
  * 描述: MVP模式
  */
interface IPresenter<out View : IMvpView<IPresenter<View>>> : ILifecycle {
    val view: View
}

interface IMvpView<out Presenter : IPresenter<IMvpView<Presenter>>> : ILifecycle {
    val presenter: Presenter
}