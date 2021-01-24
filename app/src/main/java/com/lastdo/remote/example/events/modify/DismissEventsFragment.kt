package com.lastdo.remote.example.events.modify

import com.lastdo.remote.event.modify.DismissEventsIntent

class DismissEventsFragment : DisableEventsFragment() {
    override val lastDoIntent = DismissEventsIntent()
}