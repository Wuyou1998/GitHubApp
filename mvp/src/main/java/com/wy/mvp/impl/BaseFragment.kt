package com.wy.mvp.impl

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.wy.mvp.IMvpView
import com.wy.mvp.IPresenter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure


/* 名称: GitHubApp.com.wy.mvp.impl.BaseFragment
  * 用户: _VIEW
  * 时间: 2019/9/2,17:02
  * 描述: Fragment 基类
  */
abstract class BaseFragment<out P : BasePresenter<BaseFragment<P>>> : Fragment(), IMvpView<P> {
    override val presenter: P

    init {
        presenter = createPresenter()
        presenter.view = this
    }

    private fun createPresenter(): P {
        sequence {
            var thisClass: KClass<*> = this@BaseFragment::class
            while (true) {
                yield(thisClass.supertypes)
                thisClass = thisClass.supertypes.firstOrNull()?.jvmErasure ?: break
            }
        }.flatMap {
            it.flatMap { it.arguments }.asSequence()
        }.first {
            it.type?.jvmErasure?.isSubclassOf(IPresenter::class) ?: false
        }.let {
            return it.type!!.jvmErasure.primaryConstructor!!.call() as P
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState)
    }


    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }
}

class MainFragment : BaseFragment<MainPresenter>()
class MainPresenter : BasePresenter<MainFragment>() {
    override fun onPause() {
        super.onPause()
        Log.e("测试", "onPause")
    }
}