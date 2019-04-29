package com.my_project.animationssample

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.my_project.animationssample.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        if (savedInstanceState == null) showFragment(BaseAnimationFragment())
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        toolbar.title = menuItem.title

        when (menuItem.itemId) {
            R.id.simple_anim -> showFragment(SimpleAnimationFragment())
            R.id.base_anim -> showFragment(BaseAnimationFragment())
            R.id.layout_anim -> showFragment(LayoutAnimationsFragment())
            R.id.ad_anim -> showFragment(AnimationDrawableFragment())
            R.id.avd_anim -> showFragment(AnimatedVectorDrawableFragment())
            R.id.gif_anim -> showFragment(GifFragment())
            R.id.glide_anim -> showFragment(GlideFragment())
            R.id.ripple_anim -> showFragment(RippleFragment())
            R.id.sample_transition -> showFragment(TransitionsFrameworkFragment())
            R.id.circular_spring_anim -> showFragment(CircularAndSpringFragment())
            R.id.element_transition_anim -> showFragment(SharedElementTransitionFragment())
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun initViews() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left, R.animator.slide_in_left, R.animator.slide_out_right)
            .commitAllowingStateLoss()
    }
}
