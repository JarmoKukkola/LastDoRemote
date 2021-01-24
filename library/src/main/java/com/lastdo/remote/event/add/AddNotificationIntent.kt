package com.lastdo.remote.event.add

import com.lastdo.remote.enums.EventType

/**
 * Usage example:
 *
 * val hour = "12"
 * val minute = "0"
 * val topic = "Lunch Time"
 * val days = booleanArrayOf(true, true, true, true, false, false)
 * sendBroadCast(context, hour, minute, "Lunch Time", days)
 */

class AddNotificationIntent : AddAlarmIntent() {
    override val eventType = EventType.Notification
}