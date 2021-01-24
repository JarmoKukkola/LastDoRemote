package com.lastdo.remote.event.add

import android.content.Context
import com.lastdo.remote.enums.EventType

/**
 * Usage example:
 *
 * val topic = "Sticky note to show in notifications"
 * AddNotificationIntent().sendBroadcast(context,topic)
 */

class AddPersistentNotificationIntent : AddAlarmIntent() {
    override val eventType = EventType.Persistent
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(String::class.java, "android.intent.extra.alarm.MESSAGE")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to create a new event.
     *
     * @param context application context.
     * @param topic topic of the persistent notification
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadCast(
        context: Context,
        topic: String,
        accessKey: String = ""
    ) {
        sendBroadcast(context, listOf(topic, accessKey))
    }
}