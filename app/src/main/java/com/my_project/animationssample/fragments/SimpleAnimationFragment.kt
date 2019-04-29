package com.my_project.animationssample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_simple_animation.*

/**
 * Created Максим on 26.04.2019.
 * Copyright © Max
 */
class SimpleAnimationFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_simple_animation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        alphaButton.setOnClickListener(::setListener)
        comboButton.setOnClickListener(::setListener)
        rotateButton.setOnClickListener(::setListener)
        scaleButton.setOnClickListener(::setListener)
        transButton.setOnClickListener(::setListener)
        pulsationButton.setOnClickListener(::setListener)
        trembleButton.setOnClickListener(::setListener)
        slideButton.setOnClickListener(::setListener)
    }

    override fun onPause() {
        super.onPause()
        pulsationImageButton.clearAnimation()
    }

    private fun setListener(view: View) {
        when (view.id) {
            R.id.alphaButton -> sAnimImageView.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_alpha
                )
            )
            R.id.comboButton -> sAnimImageView.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_combo
                )
            )
            R.id.rotateButton -> sAnimImageView.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_rotate
                )
            )
            R.id.scaleButton -> sAnimImageView.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_scale
                )
            )
            R.id.transButton -> sAnimImageView.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_trans
                )
            )
            R.id.pulsationButton -> pulsationImageButton.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.pulsation
                )
            )
            R.id.trembleButton -> trembleButton.startAnimation(
                AnimationUtils.loadAnimation(
                    context,
                    R.anim.anim_tremble
                )
            )
            R.id.slideButton -> {
                val anim = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
                anim.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {

                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })
                slideButton.startAnimation(anim)
            }
        }
    }
}