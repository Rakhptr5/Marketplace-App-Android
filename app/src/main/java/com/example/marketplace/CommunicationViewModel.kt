package com.example.marketplace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class CommunicationViewModel : ViewModel() {
    private val mName = MutableLiveData<String>()
    private val mNama = MutableLiveData<String>()
    val name: LiveData<String>
        get() = mName

    fun setName(name: String) {
        mName.value = name
    }
    val nama: LiveData<String>
        get() = mNama

    fun setNama(nama: String) {
        mNama.value = nama
    }
}