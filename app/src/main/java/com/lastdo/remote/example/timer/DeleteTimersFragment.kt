package com.lastdo.remote.example.notes

import com.lastdo.remote.example.AbstractIntentFragment
import com.lastdo.remote.timer.DeleteTimersIntent

class DeleteTimersFragment : AbstractIntentFragment() {
    override val lastDoIntent = DeleteTimersIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadcast(
                requireContext(),
                topic = it[0],
                accessKey = it.last()
            )
        }
    }
}