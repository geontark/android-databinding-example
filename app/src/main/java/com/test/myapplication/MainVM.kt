package com.test.myapplication

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

class MainVM {
    val _oneWay = MutableLiveData<String>()
    val oneWay: LiveData<String> = _oneWay

    val twoWay = MutableLiveData<String>()
    private val mediator = MediatorLiveData<String>().apply {
        addSource(twoWay) { value ->
            setValue(value)
            // write Logic
        }
    }.also { it.observeForever { /* empty */ } }


    fun oneWayF(s: Editable) {
        if (_oneWay.value != s.toString()) _oneWay.postValue(s.toString())
    }

}