package com.example.cognizantreveng

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    var TAG = MyService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "My service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        // Receives the intent sent from MainActivity through the intent with the same name ("url")
        Log.i(TAG, "My service started -- " + intent?.getStringExtra("url")) // "?" check if its null
        var player = MediaPlayer.create(this, R.raw.tune)
        player.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "My service destroyed")
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}