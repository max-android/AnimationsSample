package com.my_project.animationssample.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * Created Максим on 29.04.2019.
 * Copyright © Max
 */
class MyAdapter(private val action: (User) -> Unit) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    private val items: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(com.my_project.animationssample.R.layout.item_user, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val user = items[position]
        setAnimation(holder.itemView, position)
        holder.bindTo(user)
    }

    override fun getItemCount() = items.size

    fun setData(users: List<User>) {
        //items.clear()
        items.addAll(users)
    }

    fun updateData(users: List<User>) {
        items.clear()
        items.addAll(users)
        notifyDataSetChanged()
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        var mLastPosition = -1
        if (position > mLastPosition) {


//            viewToAnimate.startAnimation(android.view.animation.AnimationUtils
//                .loadAnimation(viewToAnimate.context, R.anim.anim_scroll))

//            FlingAnimation(viewToAnimate, DynamicAnimation.SCROLL_Y).apply {
//                setStartVelocity(0f)
//                setMinValue(0f)
//                setMaxValue(1f)
//                friction = 0.1f
//            }.start()

//            val anim = ScaleAnimation(
//                0.0f,
//                1.0f,
//                0.0f,
//                1.0f,
//                Animation.RELATIVE_TO_SELF,
//                0.5f,
//                Animation.RELATIVE_TO_SELF,
//                0.5f
//            )
//            anim.duration = 200L
//            viewToAnimate.startAnimation(anim)
            mLastPosition = position
        }
    }

    inner class MyHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        private var textName = containerView.findViewById(com.my_project.animationssample.R.id.nameTextView) as TextView
        private var textLName =
            containerView.findViewById(com.my_project.animationssample.R.id.lastTextView) as TextView

        init {
            containerView.setOnClickListener { action(items[layoutPosition]) }
        }

        fun bindTo(users: User) = with(users) {
            textName.text = firstName
            textLName.text = lastName
        }
    }
}