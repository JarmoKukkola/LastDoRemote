package com.lastdo.remote.example.events.modify

import com.lastdo.remote.enums.EventType
import com.lastdo.remote.event.modify.AbstractEventsModifyIntent
import com.lastdo.remote.event.modify.DisableEventsIntent
import com.lastdo.remote.example.AbstractIntentFragment

open class DisableEventsFragment : AbstractIntentFragment() {
    override val lastDoIntent: AbstractEventsModifyIntent = DisableEventsIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadCast(
                requireContext(),
                topic = it[0],
                tag = it[1],
                eventType = (it[2].toIntOrNull() ?: EventType.Alarm.ordinal).let {
                    EventType.values().getOrNull(it) ?: EventType.Alarm
                },
                maxFutureSeconds = it[3].toIntOrNull() ?: 0,
                accessKey = it.last()
            )
        }
    }
}