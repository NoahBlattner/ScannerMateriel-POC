package com.divtec.blatnoa.scannermateriel_poc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.divtec.blatnoa.scannermateriel_poc.api_activity.ApiActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private val ACTION_STRING = "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED"

    private lateinit var scanText: TextView
    private lateinit var apiButton: Button
    private lateinit var nfcButton: Button

    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the components
        scanText = findViewById(R.id.scannerText)
        apiButton = findViewById(R.id.apiButton)
        nfcButton = findViewById(R.id.nfcTestButton)

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

    override fun onStart() {
        super.onStart()

        // Set the button listener
        apiButton.setOnClickListener {
            // Create the intent
            val intent = Intent(this, ApiActivity::class.java)
            // Start the activity
            startActivity(intent)
        }

        nfcButton.setOnClickListener {
            // Create the intent
            val intent = Intent(this, NfcReadActivity::class.java)
            // Start the activity
            startActivity(intent)
        }
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