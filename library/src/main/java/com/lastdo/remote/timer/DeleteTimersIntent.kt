package com.lastdo.remote.timer

import android.content.Context
import com.lastdo.remote.event.AbstractTimerIntent

/**
 * Usage example:
 *
 * val timerTopic = "Exact timer topic"
 * // val timerTopic = "Timer topic start*"
 * // val timerTopic = "*Timer topic end"
 * // val timerTopic = "*text that timer topic contains*"
 * DeleteTimersIntent().sendBroadcast(context, timerTopic)
 */

class DeleteTimersIntent : AbstractTimerIntent() {
    override val action = "DELETE_TIMERS"
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(String::class.java, "android.intent.extra.alarm.MESSAGE")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to delete timers.
     *
     * @param context application context.
     * @param topic topic of the event.  Wild cards are allowed,
     *          such as, "*is*" is a match with card "Fish".
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadcast(
        context: Context,
        topic: String = "",
        accessKey: String = ""
    ) {
        sendBroadcast(context, listOf(topic, accessKey))
    }
}