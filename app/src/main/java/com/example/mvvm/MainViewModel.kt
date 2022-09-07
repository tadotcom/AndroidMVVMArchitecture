package com.example.mvvm

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val editTextLiveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val okBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val cancelBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val textLiveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    //エディットテキストの文字列の取得
    fun onEditText(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                editTextLiveData.value = s.toString()
            }
        }
    }

    //OKボタン
    fun okBtnClick() {
        okBtnLiveData.value = true
        cancelBtnLiveData.value = false
        textLiveData.value = editTextLiveData.value
    }

    //cancelボタン
    fun cancelBtnClick() {
        okBtnLiveData.value = false
        cancelBtnLiveData.value = true
        textLiveData.value = ""
        editTextLiveData.value = ""

    }
}