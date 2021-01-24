package com.lastdo.remote.event.add

import com.lastdo.remote.enums.EventType

/**
 * Usage example:
 *
 * val hour = "8"
 * val minute = "0"
 * val topic = "Wake Up with Challenge to Increase Alertness"
 * AddChallengeAlarmIntent().sendBroadcast(context,hour,minute,topic)
 */

class AddChallengeAlarmIntent : AddAlarmIntent() {
    override val eventType = EventType.Challenge
}