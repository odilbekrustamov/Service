package com.exsample.service

import android.app.DownloadManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.webkit.CookieManager
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.exsample.service.databinding.ActivityFileDownloadBinding


class FileDownloadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFileDownloadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFileDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

        binding.btn.setOnClickListener {

            val url = binding.link.text.toString()

            val request = DownloadManager.Request(Uri.parse(url))
            val title = URLUtil.guessFileName(url, null, null)
            request.setTitle(title)
            request.setDescription("Downloading File please wait...")

            val cookie = CookieManager.getInstance().getCookie(url)
            request.addRequestHeader("cookie", cookie)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title)


            val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            downloadManager.enqueue(request)

            Toast.makeText(this, "Downloading Start", Toast.LENGTH_SHORT).show()

        }

    }
}