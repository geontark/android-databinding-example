package com.test.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.test.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleOwner {
    lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = MainVM()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = this@MainActivity.viewmodel
        }
    }
}