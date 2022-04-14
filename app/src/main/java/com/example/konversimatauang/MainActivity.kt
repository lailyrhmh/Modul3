package com.example.konversimatauang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.konversimatauang.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateCurrency() }
    }

    fun calculateCurrency() {
        val stringInTextField = binding.currencyValue.text.toString()
        //val value = stringInTextField.toDouble()

        val selecedId = binding.currencies.checkedRadioButtonId
        val convertCurrency = when (selecedId) {
            R.id.option_euro -> 15620.81
            R.id.option_usd -> 14366.00
            R.id.option_riyal -> 114.51
            else -> 03831.34
        }


        val value = stringInTextField.toDoubleOrNull()
        if (value == null) {
            binding.result.text = " "
            return
        }

        var result = convertCurrency * value

        val IDR = Locale("in", "ID")
        val formattedCurrency = NumberFormat.getCurrencyInstance(IDR).format(result)
        binding.result.text = getString(R.string.currencyResult, formattedCurrency)
    }
}