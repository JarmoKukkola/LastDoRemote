package com.lastdo.remote.example.events.modify

import com.lastdo.remote.event.modify.EnableEventsIntent

class EnableEventsFragment : DisableEventsFragment() {
    override val lastDoIntent = EnableEventsIntent()
}