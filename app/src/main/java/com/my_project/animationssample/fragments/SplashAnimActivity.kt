package com.my_project.animationssample.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.my_project.animationssample.MainActivity
import com.my_project.animationssample.R
import kotlinx.android.synthetic.main.activity_splash_anim.*

class SplashAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_anim)

        splashImage.startAnimation(AnimationUtils.makeInAnimation(this,true))

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(
                R.anim.anim_splash_enter,
                R.anim.anim_splash_exit
            )
            finish()
        }, 2000L)
    }
}
