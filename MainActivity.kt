package com.divtec.blatnoa.scannermateriel_poc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val ACTION_STRING = "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED"

    private lateinit var scanText: TextView

    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the components
        scanText = findViewById(R.id.scannerText)

        // Create the broadcast receiver
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                // Get the data from the intent
                val code = intent.getStringExtra("data")

                if (code != null && !code.isEmpty()) {
                    // Display the data
                    scanText.text = code
                    Toast.makeText(context, code, Toast.LENGTH_SHORT).show()
                }
            }
        }

        registerScannerReceiver(receiver)
    }

    /**
     * Register the broadcast receiver
     * @param receiver the broadcast receiver
     */
    private fun registerScannerReceiver(receiver: BroadcastReceiver) {
        val filter = IntentFilter()
        filter.addAction(ACTION_STRING)
        registerReceiver(receiver, filter)
    }
}