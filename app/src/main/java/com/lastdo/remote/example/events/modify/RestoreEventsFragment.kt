package com.lastdo.remote.example.events.modify

import com.lastdo.remote.event.modify.RestoreEventsIntent

class RestoreEventsFragment : DisableEventsFragment() {
    override val lastDoIntent = RestoreEventsIntent()
}