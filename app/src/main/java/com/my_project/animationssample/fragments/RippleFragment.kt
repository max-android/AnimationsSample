package com.my_project.animationssample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.animationssample.R

/**
 * Created Максим on 28.04.2019.
 * Copyright © Max
 */
class RippleFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ripple_animation,container,false)
    }

}