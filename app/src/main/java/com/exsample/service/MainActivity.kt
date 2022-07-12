package com.exsample.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.exsample.service.databinding.ActivityMainBinding
import com.exsample.service.service.BackgroundService
import com.exsample.service.service.ForegroundService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

        binding.startService.setOnClickListener {
            startService()
        }

        binding.stopService.setOnClickListener {
            stopService()
        }

        binding.fileDownload.setOnClickListener {
            val intent = Intent(this, FileDownloadActivity::class.java)
            startActivity(intent)
        }

        binding.backgroundService.setOnClickListener {
            startService(Intent(application, BackgroundService::class.java))
        }
    }

    fun startService(){
        val input = binding.editText.text.toString()

        val serviceIntent = Intent(this, ForegroundService::class.java)
        serviceIntent.putExtra("inputExtra", input)

        ContextCompat.startForegroundService(this, serviceIntent)
    }

    fun stopService(){
        val serviceIntent = Intent(this, ForegroundService::class.java)
        stopService(serviceIntent)
    }
}