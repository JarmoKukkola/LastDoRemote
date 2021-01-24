package com.lastdo.remote.example.events.add

import com.lastdo.remote.enums.RepeatType
import com.lastdo.remote.event.add.AddAlarmIntent
import com.lastdo.remote.example.AbstractIntentFragment

open class AddAlarmFragment : AbstractIntentFragment() {
    override val lastDoIntent = AddAlarmIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadCast(
                requireContext(),
                hour = it[0].toIntOrNull() ?: 8,
                minute = it[1].toIntOrNull() ?: 0,
                topic = it[2],
                description = it[3],
                profile = it[4].toIntOrNull() ?: -1,
                repeatType = (it[5].toIntOrNull() ?: RepeatType.NoRepeat.ordinal).let {
                    RepeatType.values().getOrNull(it) ?: RepeatType.NoRepeat
                },
                repeatFrequency = it[6].toIntOrNull() ?: 1,
                accessKey = it.last()
            )
        }
    }
}