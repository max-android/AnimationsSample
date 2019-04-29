package com.my_project.animationssample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_glide_anim.*

/**
 * Created Максим on 28.04.2019.
 * Copyright © Max
 */
class GlideFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_glide_anim,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Glide.with(this)
            .asGif()
            //.placeholder(R.drawable.ic_android)
            .load(R.raw.nature)
            .into(glideImageView)
    }

}