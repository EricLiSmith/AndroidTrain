package com.dudu.implicitintents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ShareCompat
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val logTag = this.javaClass.name
    private lateinit var etWebURL: EditText
    private lateinit var etMapLocation: EditText
    private lateinit var etShareText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
    }

    private fun initComponent() {
        etWebURL = findViewById(R.id.etWebURL)
        etMapLocation = findViewById(R.id.etMapLocation)
        etShareText = findViewById(R.id.etShareText)
    }

    fun openWebSite(@Suppress("UNUSED_PARAMETER") view: View) {
        val url = etWebURL.text.toString()
        //Parse the URI and Create the intent
        val webPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)

        //Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(packageManager) != null) { //ensure one activity can handle request on the device
            startActivity(intent)
        } else {
            Log.d(logTag, "Can't handle this !!")
        }
    }

    fun openMap(@Suppress("UNUSED_PARAMETER") view: View) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        val loc = etMapLocation.text.toString()

        // Parse the location and create the intent.
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(logTag, "Can't handle this intent !!")
        }
    }

    fun shareText(@Suppress("UNUSED_PARAMETER") view: View) {
        val shareTxt = etShareText.text.toString()
        //define mime type of the txt
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType) //MIME type ot the item to be shared
            .setChooserTitle("Share this text with: ") //appears on the system app chooser
            .setText(shareTxt) //share text
            .startChooser() //Show the system app chooser and send the Intent
    }

    fun openCamera(@Suppress("UNUSED_PARAMETER") view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(logTag, "Can't handle this intent !!")
        }
    }

}
