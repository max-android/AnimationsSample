package com.my_project.animationssample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.fragment_gif_anim.*

/**
 * Created Максим on 27.04.2019.
 * Copyright © Max
 */
class GifFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gif_anim, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        gifWebView.apply {
            setInitialScale(1)
            settings.loadWithOverviewMode = true
            isVerticalScrollBarEnabled = false
            settings.useWideViewPort = true
            isHorizontalScrollBarEnabled = false
            loadUrl("file:///android_asset/rose_gif.gif")
        }
    }

}