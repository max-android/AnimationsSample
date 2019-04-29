package com.my_project.animationssample.fragments

import android.animation.*
import android.graphics.Color
import android.graphics.Color.alpha
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_base_animation.*


/**
 * Created Максим on 25.04.2019.
 * Copyright © Max
 */
class BaseAnimationFragment : Fragment() {

    private var scale = true
    private val animator = ValueAnimator.ofFloat(0f, 1f)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.my_project.animationssample.R.layout.fragment_base_animation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //ObjectAnimator with xml
        animateInflater()

        //ScaleAnimation
        scaleAnimButton.setOnClickListener {
            scale = if (scale) {
                scaleOpenAnim()
                false
            } else {
                scaleCloseAnim()
                true
            }
        }
        //LayoutTransition
        sampleLayoutTransition()

        //ViewPropertyAnim
        vPropertyAnimButton.setOnClickListener { startSecondViewPropertyAnim() }

        //ValueAnimator
        baseImageButton.setOnClickListener { sampleAnimator() }

        //ObjectAnimator
        // objectAnimButton.setOnClickListener { firstSampleObjectAnimator() }
        objectAnimButton.setOnClickListener { secondSampleObjectAnimator() }

        hsvAnimButton.setOnClickListener { hsv() }

    }

    override fun onPause() {
        super.onPause()
        animator.cancel()
    }

    private fun animateInflater() {
        val set = AnimatorInflater.loadAnimator(
            context,
            com.my_project.animationssample.R.animator.open_animator
        )
        set.setTarget(baseImageView)
        set.start()
    }

    private fun scaleOpenAnim() {
        val anim = ScaleAnimation(
            0F, 1F, 0F, 1F, 0F, baseImageView.measuredHeight.toFloat()
        )
        anim.duration = 3000L
        anim.interpolator = DecelerateInterpolator()
        anim.fillAfter = true
        baseImageView.startAnimation(anim)
    }

    private fun scaleCloseAnim() {
        val anim = ScaleAnimation(
            1F, 0F, 1F, 0F,
            0F, baseImageView.measuredHeight.toFloat()
        )
        anim.duration = 3000L
        anim.interpolator = AccelerateInterpolator()
        anim.fillAfter = true
        baseImageView.startAnimation(anim)
    }

    private fun sampleLayoutTransition() {
        val layoutTransition = frameLayout.layoutTransition
        layoutTransition.setDuration(LayoutTransition.APPEARING, 3000L)
        lChangeAnimButton.setOnClickListener { frameImageView.visibility = View.VISIBLE }
    }

    private fun startFirstViewPropertyAnim() {
        baseImageView.animate()
            .apply {
                //  rotation(360f)
                duration = 3000L
                interpolator = BounceInterpolator()
                alpha(0.5F)
                scaleX(0.5F)
                scaleY(0.5F)
                setListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {

                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationStart(animation: Animator?) {

                    }

                })
//                scaleXBy( 0.5F)
//                scaleYBy( 0.5F)
            }.start()
    }

    private fun startSecondViewPropertyAnim() {

        ViewCompat.animate(baseImageView).apply {
            scaleX(1f)
            scaleY(1f)
            duration = 2000L
            interpolator = BounceInterpolator()
            rotation(360f)
            translationX(100f)
//            withStartAction { baseImageButton.visibility = View.GONE }
//            withEndAction { baseImageButton.visibility = View.VISIBLE }
        }.start()

    }

    private fun sampleAnimator() {
        animator.duration = 2000L
        animator.interpolator = BounceInterpolator()
        animator.addUpdateListener {
            val value = animator.animatedValue as Float
            baseImageButton.scaleX = value
            baseImageButton.scaleY = value
        }
        animator.start()
    }

    private fun firstSampleObjectAnimator() {
        val animationX = ObjectAnimator.ofFloat(baseImageView, "scaleX", 0.5F)
        val animationY = ObjectAnimator.ofFloat(baseImageView, "scaleY", 0.5F)
        val rotation = ObjectAnimator.ofFloat(baseImageView, "rotation", 360F)
        val backgroundColor = ObjectAnimator.ofObject(
            baseImageView, "backgroundColor", ArgbEvaluator(),
            /*Red*/0xFFFF8080, /*Blue*/0xFF8080FF
        )
        AnimatorSet().apply {
            play(animationX).with(animationY).with(rotation).with(backgroundColor)
            duration = 3000L
            interpolator = DecelerateInterpolator()
        }.start()
    }

    private fun secondSampleObjectAnimator() {
        // Define first set of animations
        val anim1 = ObjectAnimator.ofFloat(baseImageView, "scaleX", 2.0f)
        val anim2 = ObjectAnimator.ofFloat(baseImageView, "scaleY", 2.0f)
        val set1 = AnimatorSet()
        set1.playTogether(anim1, anim2)
        // Define second set of animations
        val anim3 = ObjectAnimator.ofFloat(baseImageView, "X", 300f)
        val anim4 = ObjectAnimator.ofFloat(baseImageView, "Y", 300f)
        val set2 = AnimatorSet()
        set2.playTogether(anim3, anim4)
        // Play the animation sets one after another
        val set3 = AnimatorSet()
        set3.playSequentially(set1, set2)
        set3.start()
    }

    private fun hsv(){

        val from = FloatArray(3)
        val to = FloatArray(3)
        val hsv = FloatArray(3)

        Color.colorToHSV(ContextCompat.getColor(context!!, R.color.defaultNormalColor),from)
        Color.colorToHSV(ContextCompat.getColor(context!!, R.color.defaultDisabledColor),to)

        val hsvAnimator = ValueAnimator.ofFloat(0f,1f)
        hsvAnimator.addUpdateListener {
            hsv[0] = from[0] + (to[0] - from[0])*it.animatedFraction
            hsv[1] = from[1] + (to[1] - from[1])*it.animatedFraction
            hsv[2] = from[2] + (to[2] - from[2])*it.animatedFraction
            hsvAnimButton.setBackgroundColor(Color.HSVToColor(hsv))
        }
        hsvAnimator.start()
    }
}