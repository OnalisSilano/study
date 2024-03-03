package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculatorTip_20PercentNoRoundUp() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2.0)

        val actualTip = calculateTip(
            amount = amount,
            tipPercent = tipPercent,
            roundUp = false,
        )

        assertEquals(expectedTip,actualTip)
    }
}