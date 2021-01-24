package com.lastdo.remote.example.notes

import com.lastdo.remote.example.AbstractIntentFragment
import com.lastdo.remote.timer.CreateTimerIntent

class CreateTimerFragment : AbstractIntentFragment() {
    override val lastDoIntent = CreateTimerIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadcast(
                requireContext(),
                hour = it[0].toIntOrNull() ?: 0,
                minute = it[1].toIntOrNull() ?: 10,
                second = it[2].toIntOrNull() ?: 0,
                topic = it[3],
                accessKey = it.last()
            )
        }
    }
}