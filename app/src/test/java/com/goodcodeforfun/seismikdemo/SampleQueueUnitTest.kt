package com.goodcodeforfun.seismikdemo

import com.goodcodeforfun.seismik.Sample
import com.goodcodeforfun.seismik.SampleQueue
import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SampleQueueUnitTest {
    @Test
    fun sampleQueueAsListIsCorrect() {
        val queue = SampleQueue()
        val testSampleArrayList = ArrayList<Sample>()
        var x = 10
        while (x-- > 0) {
            val testSample = Sample()
            testSample.timestamp = Date().time
            testSample.accelerating = false
            queue.add(testSample.timestamp, testSample.accelerating)
            testSampleArrayList.add(testSample)
        }

        val sampleList = queue.asList()
        Assert.assertEquals(testSampleArrayList.size, sampleList.size)

        for (sample in sampleList) {
            Assert.assertEquals(testSampleArrayList[sampleList.indexOf(sample)].timestamp, sample.timestamp)
            Assert.assertEquals(testSampleArrayList[sampleList.indexOf(sample)].accelerating, sample.accelerating)
        }
    }
}