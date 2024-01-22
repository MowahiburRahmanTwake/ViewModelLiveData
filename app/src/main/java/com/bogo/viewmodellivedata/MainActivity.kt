package com.bogo.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bogo.viewmodellivedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        var count:LiveData<Int> = mainViewModel.getInitialCounter()
        count.observe(this){
        binding.countText.text = it.toString()
        }


        binding.coutBtn.setOnClickListener {
            val count = binding.countText.text.toString().toInt() + 1
            binding.countText.text = count.toString()
        }
    }
}