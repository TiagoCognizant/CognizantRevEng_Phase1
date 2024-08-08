package com.example.cognizantreveng

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cognizantreveng.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val constraintLayout = binding.root
        setContentView(constraintLayout)
    }

    override fun onStart() {
        super.onStart()
        var serviceIntent = Intent(this, MyService::class.java)

        //start a service
        binding.btnStart.setOnClickListener{ startService(serviceIntent) }

        //stop a service
        binding.btnStop.setOnClickListener{ stopService(serviceIntent) }
    }


    // Write in editText then print the content on textView
    fun clickHandler(view: View) {
        var nameEditText :  EditText = findViewById(R.id.edName)
        var mainTextView : TextView = findViewById(R.id.tvMain)

        var data = nameEditText.text.toString()
        mainTextView.setText(data)

        //takes the data info to an intent that opens another activity HomeActivity.java
        var hIntention = Intent(this, HomeActivity::class.java)
        //sends info with name mykey with the data in data
        hIntention.putExtra("mykey", data)
        //opens acticvity
        startActivity(hIntention)
    }

    fun openDailer(view: View) {
        var dialerInterntion = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"))
        startActivity(dialerInterntion)
    }


    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
      //  if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
       // }
    }

    fun setAlarm(view: View) {
        createAlarm("Im coming for you!", 3,25 )
    }

    fun openMyCalendar(view: View) {

        //var calIntent = Intent("cognizant.portugal.android")
        var calIntent = Intent("ineed.water")
        startActivity(calIntent)

    }

    fun sendFLightBroadcast(view: View) {
        var flightIntent = Intent("ihave.flight")
        sendBroadcast(flightIntent)
    }


}