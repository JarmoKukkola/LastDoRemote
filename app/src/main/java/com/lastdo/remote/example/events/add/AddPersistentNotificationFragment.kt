package com.lastdo.remote.example.events.add

import com.lastdo.remote.event.add.AddPersistentNotificationIntent
import com.lastdo.remote.example.AbstractIntentFragment

class AddPersistentNotificationFragment : AbstractIntentFragment() {
    override val lastDoIntent = AddPersistentNotificationIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadCast(
                requireContext(),
                topic = it[0],
                accessKey = it.last()
            )
        }
    }
}