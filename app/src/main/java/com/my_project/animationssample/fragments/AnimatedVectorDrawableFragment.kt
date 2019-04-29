package com.my_project.animationssample.fragments

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_animated_vector_drawable.*

/**
 * Created Максим on 27.04.2019.
 * Copyright © Max
 */
class AnimatedVectorDrawableFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_animated_vector_drawable, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startAvdButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                (avdImageView.drawable as AnimatedVectorDrawable).start()
        }

    }
}