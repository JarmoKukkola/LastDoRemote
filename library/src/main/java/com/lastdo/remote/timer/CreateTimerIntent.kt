package com.lastdo.remote.timer

import android.content.Context
import com.lastdo.remote.event.AbstractTimerIntent

/**
 * Usage example:
 *
 * val hour = "0"
 * val minute = "10"
 * val second = "0"
 * val topic = "Eggs done boiling"
 * CreateTimerIntent().sendBroadcast(context,hour,minute,second, topic)
 */

open class CreateTimerIntent : AbstractTimerIntent() {
    override val action = "CREATE_TIMER"
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(Int::class.java, "android.intent.extra.alarm.HOUR"),
        Pair(Int::class.java, "android.intent.extra.alarm.MINUTES"),
        Pair(Int::class.java, "SECONDS"),
        Pair(String::class.java, "android.intent.extra.alarm.MESSAGE")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to create a new timer.
     *
     * @param context application context.
     * @param hour hour of day
     * @param minute minute of hour
     * @param second second of minute
     * @param topic topic of the event
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadcast(
        context: Context,
        hour: Int = 0,
        minute: Int = 10,
        second: Int = 0,
        topic: String = "",
        accessKey: String = ""
    ) {
        sendBroadcast(
            context,
            listOf(
                hour.toString(),
                minute.toString(),
                second.toString(),
                topic,
                accessKey
            )
        )
    }
}