package com.lastdo.remote.event.add

import android.content.Context
import com.lastdo.remote.enums.EventType
import com.lastdo.remote.enums.RepeatType
import com.lastdo.remote.event.AbstractEventIntent

/**
 * Usage example:
 *
 * val hour = "8"
 * val minute = "0"
 * val topic = "Wake up"
 * val description = "More details"
 * val profileIndex = 0 // -1 means no profile, 0,1,2,.. means profile index
 * val accessKey = "" // optional. Only required if set in LastDo settings.
 * AddAlarmIntent().sendBroadcast(context,hour,minute,topic, description, profileIndex,accessKey)
 */

open class AddAlarmIntent : AbstractEventIntent() {
    open val eventType = EventType.Alarm

    override val action = "android.intent.action.SET_ALARM"
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(Int::class.java, "android.intent.extra.alarm.HOUR"),
        Pair(Int::class.java, "android.intent.extra.alarm.MINUTES"),
        Pair(String::class.java, "android.intent.extra.alarm.MESSAGE"),
        Pair(String::class.java, "DESCRIPTION"),
        Pair(Int::class.java, "PROFILE"),
        Pair(Int::class.java, "REPEAT_TYPE"),
        Pair(Int::class.java, "REPEAT_FREQUENCY")
    )
    override val fixedExtras: List<Triple<Class<*>, String, String>> by lazy {
        listOf(Triple(Int::class.java, "EVENT_TYPE", eventType.ordinal.toString()))
    }

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to create a new event.
     *
     * @param context application context.
     * @param hour hour of day
     * @param minute minute of hour
     * @param topic topic of the event
     * @param description description of the event
     * @param profile profile index. Value -1 means default profile and 0,1,2,.. are profile indices.
     * @param days repeat on these days. First day is Monday and last is Sunday.
     * @param accessKey only required if set in LastDo settings
     */
    fun sendBroadCast(
        context: Context,
        hour: Int = 7,
        minute: Int = 0,
        topic: String = "",
        description: String = "",
        profile: Int = -1,
        days: BooleanArray = BooleanArray(7) { true },
        accessKey: String = ""
    ) {
        sendBroadCast(
            context,
            hour,
            minute,
            topic,
            description,
            profile,
            RepeatType.Daily,
            days.map {
                if (it) 1 else 0
            }.joinToString("").toInt(),
            accessKey
        )
    }

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to create a new event.
     *
     * @param context application context.
     * @param hour hour of day
     * @param minute minute of hour
     * @param topic topic of the event
     * @param description description of the event
     * @param profile profile index. Value -1 means default profile and 0,1,2,.. are profile indices.
     * @param repeatType check RepeatType enum for different repetition types.
     * @param repeatFrequency the event is triggered every X time unit.
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadCast(
        context: Context,
        hour: Int = 7,
        minute: Int = 0,
        topic: String = "",
        description: String = "",
        profile: Int = -1,
        repeatType: RepeatType = RepeatType.NoRepeat,
        repeatFrequency: Int = 0,
        accessKey: String = ""
    ) {
        val repeatTypeIndex = repeatType.ordinal - 1
        sendBroadcast(
            context,
            listOf(
                hour.toString(),
                minute.toString(),
                topic,
                description,
                profile.toString(),
                repeatTypeIndex.toString(),
                repeatFrequency.toString(),
                accessKey
            )
        )
    }
}