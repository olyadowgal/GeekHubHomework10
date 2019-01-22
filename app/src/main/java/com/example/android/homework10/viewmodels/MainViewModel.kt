package com.example.android.homework10.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.homework10.adapters.ReposAdapter
import com.example.android.homework10.livedata.SingleLiveEvent

class MainViewModel : ViewModel(), ReposAdapter.Callback {

    val reposAdapter: ReposAdapter = ReposAdapter(this)
    private val _clickLiveEvent: SingleLiveEvent<Int> = SingleLiveEvent()
    val clickLiveEvent: LiveData<Int> = _clickLiveEvent

    override fun onUserClicked(position: Int) {
        _clickLiveEvent.value = position
    }


}