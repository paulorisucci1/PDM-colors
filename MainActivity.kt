package com.exercicios.mycolors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var redSeekBar: SeekBar
    lateinit var greenSeekBar: SeekBar
    lateinit var blueSeekBar: SeekBar
    lateinit var resultColorLayout: LinearLayout
    lateinit var hexColorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startGame()
    }

    private fun startGame() {
        findViews()
        updateHexColorTextView()
        setOnSeekBarListeners()
    }

    fun findViews() {
        redSeekBar = findViewById(R.id.redSeekBar)
        greenSeekBar = findViewById(R.id.greenSeekBar)
        blueSeekBar = findViewById(R.id.blueSeekBar)
        resultColorLayout = findViewById(R.id.resultColorLayout)
        hexColorTextView = findViewById(R.id.hexColorTextView)
    }

    private fun updateHexColorTextView() {
        hexColorTextView.text = Integer.toHexString(getResultColorFromSeekbars())
    }

    private fun setOnSeekBarListeners() {
        redSeekBar.setOnSeekBarChangeListener(ChangeResultLayoutColor());
        greenSeekBar.setOnSeekBarChangeListener(ChangeResultLayoutColor());
        blueSeekBar.setOnSeekBarChangeListener(ChangeResultLayoutColor());
    }

    fun getResultColorFromSeekbars(): Int {
        val redColor = redSeekBar.progress
        val greenColor = greenSeekBar.progress
        val blueColor = blueSeekBar.progress
        return Color.rgb(redColor, greenColor, blueColor)
    }

    inner class ChangeResultLayoutColor: OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            val resultColor = this@MainActivity.getResultColorFromSeekbars()
            resultColorLayout.setBackgroundColor(resultColor)
            updateHexColorTextView()
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {
//            TODO("Not yet implemented")
        }

        override fun onStopTrackingTouch(p0: SeekBar?) {
//            TODO("Not yet implemented")
        }

    }

}