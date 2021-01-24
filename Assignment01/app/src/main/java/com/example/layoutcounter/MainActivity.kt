package com.example.layoutcounter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.layoutcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var count: Int = 0;
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        updateCounter();
        binding.btnToast.setOnClickListener { showCount() }
        binding.btnIncrement.setOnClickListener {count(true)}
        binding.btnDecrement.setOnClickListener {count(false)}
    }

    private fun showCount(){
        Toast.makeText(this, "Hello! $count", Toast.LENGTH_SHORT).show();
    }

    private fun count(increment: Boolean) {
        if(increment) {
            count++;
        } else {
            count--;
        }
        updateCounter();
    }

    private fun updateCounter() {
        binding.Counter.text = count.toString();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        updateCounter();
    }
}