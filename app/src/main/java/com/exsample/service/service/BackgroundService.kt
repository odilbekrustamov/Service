package com.exsample.service.service

import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log

class BackgroundService: Service() {

    private val TAG = "BackgroundService"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val countDownTimer = object : CountDownTimer(60000, 1000){
            override fun onTick(millisUnitilFinished: Long) {
                Log.d(TAG, "onTick: ${millisUnitilFinished}")
            }

            override fun onFinish() {
                Log.d(TAG, "onFinish: ")
            }

        }.start()
        return START_STICKY
    }


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}