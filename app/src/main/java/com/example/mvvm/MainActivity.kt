package com.example.mvvm

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel SSS


        val textObserver = Observer<String> { newName ->
            if (binding.edit.text.isNotBlank() && binding.edit.text.isNotBlank()) {
                binding.nameTextView.text = newName
                binding.nameTextView.setTextColor(resources.getColor(R.color.black))
            } else {
                binding.nameTextView.text = "値が不正です"
                binding.nameTextView.setTextColor(resources.getColor(R.color.red))
            }
        }

        val editObserver = Observer<String> { aaa ->
            if(binding.edit != null) {
                if(mainViewModel.cancelBtnLiveData.value == true) {
                    binding.edit.text.clear()
                }
            }
        }

        mainViewModel.textLiveData.observe(this, textObserver)
        mainViewModel.editTextLiveData.observe(this, editObserver)
    }
}