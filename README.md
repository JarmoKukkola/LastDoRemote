**LastDo Remote Library**

LastDo is a life organizer app with extensive functionality. It has alarm, notifications, notes, timer, stopwatch and file sharing between devices. It has fine grained control over which functionalities 3rd parties can access.

This library is designed for 3rd party apps to interact with Android app LastDo (https://www.lastdo.com). LastDo can receive intents send by other apps to its BroadcastReceivers.

Even though the library cannot be used by users of automation apps, it describes how these apps could communicate with LastDo. See more details at the bottom of this document. Side note: LastDo Pro can trigger Tasker app tasks, when alarm or challenge alarm is dismissed.

For each type of exposed functionality, LastDoRemote folder has a class, which can be used for easy communication with LastDo app. See, for example, file AddAlarmIntent in folder LastDoRemote/src/main/java/com/lastdo/remote/event/add.

**Funtionality exposed to 3rd party apps**

* Add Alarm
* Add Challenge Alarm (for deep sleepers)
* Add Notification
* Add Persistent Notification (visible in Notification Drawer until user remove it)
* Dismiss Events (Alarm, Challenge Alarms, Notifications, Persistent Notifications)
* Enable Events
* Move Events to Trash
* Restore Events
* Create Note
* Move Notes to Trash
* Restore Notes
* Create Card (Container for Notes)
* Move Cards to Trash
* Restore Cards
* Create Timer
* Delete Timer

**Added library to Android app**

Add Jitpack to project level build.gradle file

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Add LastDoRemote library to module level build.gradle file

```
dependencies {
    implementation 'com.github.JarmoKukkola:LastDoRemote:1.0.2'
}
```

Notice that the app need permission "android.permission.SET_ALARM", if events or timers are edited.

**Demo App**

The demo app in folder "app" demonstrates all the functionalities that 3rd party apps can access. If you get toast "BroadcastReceiver called without permission" while sending an Intent to LastDo, it is a sign that you have to go to the LastDo app - Settings - Remote Access Settings. Allow external app access and allow permissions that you desire.

**Automation app users**

The parameters needed for automation apps

* Package name: "com.lastdo.app" or "com.lastdo.pro"

* Required extra, if enabled in LastDo app: "ACCESS_KEY". It can be seen and copied in settings of LastDo app.

* Class name: "com.lastdo.broadcast.EventReceiver", "com.lastdo.broadcast.NoteReceiver" or "com.lastdo.broadcast.TimerReceiver"

* Action: defined by action variable in each *Intent.kt class. For example, AddAlarmIntent.kt has action "android.intent.action.SET_ALARM"

* Extras expected: You can check the sub-folders of library/src/main/java/com/lastdo/remote/ for detailed description of each parameter accepted. For example, CreateNoteIntent.kt in sub-folder "note" describes creation of a note. Extras "NAME", "TEXT" and "CARD_NAME" are expected. Check relevant *Intent.kt files for details on other types of actions.
