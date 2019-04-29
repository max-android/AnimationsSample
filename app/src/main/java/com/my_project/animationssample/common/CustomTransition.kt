package com.my_project.animationssample.common

import android.support.transition.ChangeBounds
import android.support.transition.ChangeImageTransform
import android.support.transition.ChangeTransform
import android.support.transition.TransitionSet

/**
 * Created Максим on 27.04.2019.
 * Copyright © Max
 */
class CustomTransition:TransitionSet() {

    init {
            ordering = ORDERING_TOGETHER
            addTransition(ChangeBounds())
                .addTransition(ChangeTransform())
                .addTransition(ChangeImageTransform())
    }
}