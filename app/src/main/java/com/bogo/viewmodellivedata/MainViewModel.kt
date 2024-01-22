package com.bogo.viewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val counterLiveData =MutableLiveData<Int>()
    private var counter = 0
    fun getInitialCounter():MutableLiveData<Int> {
        counterLiveData.value = counter
        return counterLiveData
    }
    fun getCounter(){
        counter++
    }
}