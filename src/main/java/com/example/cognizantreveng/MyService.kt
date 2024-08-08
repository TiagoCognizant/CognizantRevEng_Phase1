package com.example.cognizantreveng

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    var TAG = MyService::class.java.simpleName
    private val localBinder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getMyService() : MyService = this@MyService
    }


    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "My service created")
    }

    fun latestScore() : Int{
        return 5
    }

    fun add (a:Int, b:Int): Int{
        return a + b
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
        Log.i(TAG, "Some activity is trying to bind to service")
        return LocalBinder()
    }
}