package com.shante.composetopicapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicStringResourceId: Int,
    val availableCourses: Int,
    @DrawableRes val topicImageResourceId: Int
)
