package com.lastdo.remote.event.modify

/**
 * Usage example:
 *
 * val topic = "exact topic text"
 * // val topic = "topic that starts with*"
 * // val topic = "*topic that ends with"
 * // val topic = "*topic that contains*"
 * val tag = "partial tag name" //if tag is null or empty,  ignore.
 * val eventType = EventType.Alarm  // or .Challenge or .Noticication or .Persistent
 * val maxFutureSeconds = 60*60*24 // only modify events that are max 24 hours in the future
 * val accessKey = "" // optional. Only required if set in LastDo settings.
 * EnableEventsIntent().sendBroadcast(context,topic,tag, eventType, maxFutureSeconds,accessKey)
 * EnableEventsIntent().sendBroadcast(context,topic,tag) // all event types
 * EnableEventsIntent().sendBroadcast(context,topic) // all tags and event types
 * EnableEventsIntent().sendBroadcast(context) // all events
 * EnableEventsIntent().sendBroadcast(context,tag = "work") // all tags that contains "work" string
 * EnableEventsIntent().sendBroadcast(context,eventType = EventType.Alarm) // all alarms
 */

class EnableEventsIntent : AbstractEventsModifyIntent() {
    override val action = "ENABLE_EVENTS"
}