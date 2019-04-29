package com.my_project.animationssample.fragments

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_circular_spring_animation.*

/**
 * Created Максим on 26.04.2019.
 * Copyright © Max
 */
class CircularAndSpringFragment : Fragment() {

    private var isOpen = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_circular_spring_animation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            circularRevealAnimSample()
        }

        springAnimSample()

    }

    private fun circularRevealAnimSample() {
      btnStart.setOnClickListener{
          if(!isOpen){

              val x =  mainLinearLayout.right
              val y =  mainLinearLayout.bottom
              val startRadius = 0F
              val endRadius = Math.hypot(mainLinearLayout.width.toDouble(),mainLinearLayout.height.toDouble()).toFloat()
              val anim = ViewAnimationUtils.createCircularReveal(linearLayout, x, y, startRadius, endRadius)
              linearLayout.visibility = View.VISIBLE
              anim.start()
              isOpen = true
          }else{
              val x =  linearLayout.right
              val y =  linearLayout.bottom
              val startRadius = Math.max(linearLayout.width, linearLayout.height).toFloat()
              val endRadius = 0F
              val anim = ViewAnimationUtils.createCircularReveal(linearLayout, x, y, startRadius, endRadius)


              anim.addListener(object : AnimatorListenerAdapter() {

                  override fun onAnimationEnd(animation: Animator) {
                      super.onAnimationEnd(animation)
                      linearLayout.visibility = View.GONE
                  }
              })
              anim.start()
              isOpen = false
          }
        }
    }

    private fun springAnimSample(){
        springButton.setOnClickListener {
          val springAnimation = SpringAnimation(springButton, DynamicAnimation.TRANSLATION_Y, 300F)
          //val  springAnimation = SpringAnimation(springButton, DynamicAnimation.ALPHA, 0.25F)
         // val  springAnimation = SpringAnimation(springButton, DynamicAnimation.ROTATION, 180F)
            springAnimation.spring.dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
            springAnimation.addEndListener { dynamicAnimation, b, fl, f2 ->
                run {
                    SpringAnimation(springButton, DynamicAnimation.TRANSLATION_Y, 0F).start()
                }
            }
            springAnimation.spring.apply {
                dampingRatio = 0.3f
                stiffness = 100f
            }
            springAnimation.start()
        }
    }

}