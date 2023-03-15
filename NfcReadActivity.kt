package com.divtec.blatnoa.scannermateriel_poc

import android.app.PendingIntent
import android.content.Intent
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class NfcReadActivity : AppCompatActivity() {
    private lateinit var nfcDataText: TextView
    private var nfcAdapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nfc_read)

        nfcDataText = findViewById(R.id.nfcDataText)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        if (nfcAdapter == null) {
            Toast.makeText(this, "NFC not supported", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        setIntent(intent)

        // Show a toast message to indicate that the NFC intent was received
        Toast.makeText(this, "NFC intent received", Toast.LENGTH_SHORT).show()

        // Show the data from the NFC intent
        nfcDataText.text = intent?.getStringExtra(NfcAdapter.EXTRA_DATA)
    }
}