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
 * MoveEventsToTrashIntent().sendBroadcast(context,topic,tag, eventType, maxFutureSeconds,accessKey)
 * MoveEventsToTrashIntent().sendBroadcast(context,topic,tag) // all event types
 * MoveEventsToTrashIntent().sendBroadcast(context,topic) // all tags and event types
 * MoveEventsToTrashIntent().sendBroadcast(context) // all events
 * MoveEventsToTrashIntent().sendBroadcast(context, tag = "work") // all tags that contains "work" string
 * MoveEventsToTrashIntent().sendBroadcast(context, eventType = EventType.Alarm) // all alarms
 */

class MoveEventsToTrashIntent : AbstractEventsModifyIntent() {
    override val action = "MOVE_EVENTS_TO_TRASH"
}