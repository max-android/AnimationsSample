package com.my_project.animationssample.fragments

import android.os.Build
import android.os.Bundle
import android.support.transition.Fade
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.animationssample.R
import com.my_project.animationssample.common.CustomTransition
import kotlinx.android.synthetic.main.fragment_element_transition.*

/**
 * Created Максим on 27.04.2019.
 * Copyright © Max
 */
class SharedElementTransitionFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_element_transition,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        etLayout.setOnClickListener { clickElement() }
    }

    private fun clickElement(){
        val detailFragment = DetailsFragment()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            detailFragment.apply {
                //переход с первого фрагмента во второй используем метод
                sharedElementEnterTransition = CustomTransition()
                enterTransition = Fade()
                exitTransition = Fade()
            //    переход с 2-1 фрагмент
                sharedElementReturnTransition = CustomTransition()
            }
        }
        showDetail(detailFragment)
    }

    private fun showDetail(fragment: Fragment){
        activity!!.supportFragmentManager
            .beginTransaction()
            .addSharedElement(etImageView,"android")
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}