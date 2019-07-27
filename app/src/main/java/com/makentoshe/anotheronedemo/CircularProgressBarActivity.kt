package com.makentoshe.anotheronedemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class CircularProgressBarActivity : AppCompatActivity() {

    /** Content view factory */
    private val view: View
        get() = RelativeLayout(this).apply {
            ProgressBar(context).apply {
                id = R.id.circularProgressBar
                // -2 is a wrap_content
                layoutParams = RelativeLayout.LayoutParams(-2, -2).apply {
                    addRule(RelativeLayout.CENTER_IN_PARENT)
                }
            }.also(::addView)
            MaterialButton(context).apply {
                id = R.id.circrularProgressBarButton
                setText(R.string.returnToMainScreen)
                // -2 is a wrap_content
                layoutParams = RelativeLayout.LayoutParams(-2, -2).apply {
                    addRule(RelativeLayout.BELOW, R.id.circularProgressBar)
                    addRule(RelativeLayout.CENTER_HORIZONTAL)
                }
            }.also(::addView)
        }

    private val button by lazy {
        findViewById<Button>(R.id.circrularProgressBarButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view)

        button.setOnClickListener { finish() }
    }
}