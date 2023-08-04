package com.igor.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.igor.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonCalculate.setOnClickListener(this)

    }


    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val total = (distance * price) / autonomy
            binding.textValorTotal.text = "R$ ${"%.2f".format(total)}"
        } else{
            Toast.makeText(this, R.string.fill_all_filds, Toast.LENGTH_SHORT).show()
        }
    }
}