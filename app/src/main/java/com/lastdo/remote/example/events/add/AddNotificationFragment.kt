package com.lastdo.remote.example.events.add

import com.lastdo.remote.event.add.AddNotificationIntent

class AddNotificationFragment : AddAlarmFragment() {
    override val lastDoIntent = AddNotificationIntent()
}