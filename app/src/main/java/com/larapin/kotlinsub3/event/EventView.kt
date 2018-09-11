package com.larapin.kotlinsub3.event

import com.larapin.kotlinsub3.model.Event

/**
 * Created by Avin on 04/09/2018.
 */
interface EventView{
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}