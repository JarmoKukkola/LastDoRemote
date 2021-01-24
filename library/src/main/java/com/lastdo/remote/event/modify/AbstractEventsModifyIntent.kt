package com.lastdo.remote.event.modify

import android.content.Context
import com.lastdo.remote.enums.EventType
import com.lastdo.remote.event.AbstractEventIntent

abstract class AbstractEventsModifyIntent : AbstractEventIntent() {
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(String::class.java, "android.intent.extra.alarm.MESSAGE"),
        Pair(String::class.java, "TAG"),
        Pair(Int::class.java, "EVENT_TYPE"),
        Pair(Int::class.java, "MAX_FUTURE_SECONDS")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to modify events.
     *
     * @param context application context.
     * @param topic topic of the event
     * @param tag part of a tag
     * @param eventType defined by EventType enum in com.lastdo.remote.enums.EventType
     * @param maxFutureSeconds if <=0 any. Otherwise filters events that are happening later.
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadCast(
        context: Context,
        topic: String = "",
        tag: String = "",
        eventType: EventType? = null,
        maxFutureSeconds: Int = 0,
        accessKey: String = ""
    ) {
        sendBroadcast(
            context,
            listOf(
                topic,
                tag,
                eventType?.ordinal?.toString() ?: (-1).toString(),
                maxFutureSeconds.toString(),
                accessKey
            )
        )
    }
}