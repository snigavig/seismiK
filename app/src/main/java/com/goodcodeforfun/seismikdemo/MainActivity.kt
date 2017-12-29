package com.goodcodeforfun.seismikdemo

import android.app.Activity
import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import com.goodcodeforfun.seismik.ShakeDetector

class MainActivity : Activity(), ShakeDetector.Listener {
    private lateinit var shakeDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shakeDetector = ShakeDetector(this)

        setContentView(R.layout.activity_main)
        findViewById<RadioGroup>(R.id.radioGroupSensitivity).setOnCheckedChangeListener({ _, i ->
            when (i) {
                R.id.radioButtonLight -> shakeDetector.setSensitivity(ShakeDetector.Sensitivity.SENSITIVITY_LIGHT)
                R.id.radioButtonMedium -> shakeDetector.setSensitivity(ShakeDetector.Sensitivity.SENSITIVITY_MEDIUM)
                R.id.radioButtonHard -> shakeDetector.setSensitivity(ShakeDetector.Sensitivity.SENSITIVITY_HARD)
                R.id.radioButtonHarder -> shakeDetector.setSensitivity(ShakeDetector.Sensitivity.SENSITIVITY_HARDER)
                else -> throw IllegalArgumentException()
            }
        })
    }

    override fun hearShake() {
        Toast.makeText(this, getString(R.string.hear_shake_message_text), Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        shakeDetector.start(sensorManager)
        super.onStart()
    }

    override fun onStop() {
        shakeDetector.stop()
        super.onStop()
    }
}
