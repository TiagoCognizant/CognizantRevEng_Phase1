package com.example.cognizantreveng

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast


class CallReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "Phone call Incoming....")
        try {
            val tmgr = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val PhoneListener: MyPhoneStateListener = MyPhoneStateListener()
            tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE)
        } catch (e: Exception) {
            Toast.makeText(context, "oops!", Toast.LENGTH_SHORT).show()
        }
    }

    private class MyPhoneStateListener : PhoneStateListener() {
        var c: Context? = null
        override fun onCallStateChanged(state: Int, incomingNumber: String) {
            if (state == 1) {
                val msg = "New Phone Call Event. Incoming Number: $incomingNumber"
                val duration = Toast.LENGTH_LONG
                val toast = Toast.makeText(c, msg, duration)
                toast.show()
            }
        }
    }

    companion object {
        var TAG = CallReceiver::class.java.simpleName
    }
}