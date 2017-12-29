// Copyright 2010 Square, Inc.
package com.goodcodeforfun.seismik

/** An accelerometer sample.  */
class Sample {
    /** Time sample was taken.  */
    var timestamp: Long = 0

    /** If acceleration > [.accelerationThreshold].  */
    var accelerating: Boolean = false

    /** Next sample in the queue or pool.  */
    var next: Sample? = null
}