package com.my_project.animationssample.fragments

import android.os.Bundle
import android.support.transition.Scene
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_transition_sample.*
import kotlinx.android.synthetic.main.fragment_transition_scene_sample.*

/**
 * Created Максим on 26.04.2019.
 * Copyright © Max
 */
class TransitionsFrameworkFragment : Fragment() {

    private var isExpanded = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transition_sample, container, false)
        // return inflater.inflate(R.layout.fragment_transition_scene_sample, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        showTransitionSample()
        //  showTransitionWithScene()
    }

    private fun showTransitionSample() {

        trasitFrameLayout.setOnClickListener {
            TransitionManager.beginDelayedTransition(trasitFrameLayout as ViewGroup)
            if (isExpanded) {
                isExpanded = false
                expand()
            } else {
                isExpanded = true
                collapse()
            }
        }
    }

    private fun expand() {
        val lp = image.layoutParams
        lp.width = resources.getDimension(R.dimen.image_size_expanded).toInt()
        lp.height = resources.getDimension(R.dimen.image_size_expanded).toInt()
        image.layoutParams = lp
        myTitle.visibility = View.VISIBLE
        description.visibility = View.VISIBLE
    }

    private fun collapse() {
        val lp = image.layoutParams
        lp.width = resources.getDimension(R.dimen.image_size_collapsed).toInt()
        lp.height = resources.getDimension(R.dimen.image_size_collapsed).toInt()
        image.layoutParams = lp
        myTitle.visibility = View.GONE
        description.visibility = View.GONE
    }


    //используй R.layout.fragment_transition_scene_sample для данного примера
    private fun showTransitionWithScene() {

        val firstScene = Scene.getSceneForLayout(sceneRoot, R.layout.layout_scene_one, context!!)
        val secondScene = Scene.getSceneForLayout(sceneRoot, R.layout.layout_scene_two, context!!)

        changeSceneButton.setOnClickListener {
            TransitionManager.go(if (isExpanded) firstScene else secondScene)
            isExpanded = !isExpanded
        }

//        val transition: Transition = AutoTransition()
//        changeSceneButton.setOnClickListener {
//            TransitionManager.go(secondScene, transition)
//        }

    }
}