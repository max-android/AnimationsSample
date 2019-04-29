package com.my_project.animationssample.fragments

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_animated_drawable.*

/**
 * Created Максим on 28.04.2019.
 * Copyright © Max
 */
class AnimationDrawableFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_animated_drawable,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (adImageView.drawable as? AnimationDrawable)?.start()
    }
}