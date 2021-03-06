package com.assignment.nvest.sample.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.assignment.nvest.model.ResponseWrapper
import com.assignment.nvest.repository.SampleRepository
import javax.inject.Inject

open class SampleViewModel @Inject constructor(private val repository: SampleRepository) : ViewModel() {
    private var fetchedData: MutableLiveData<ResponseWrapper> = MutableLiveData()

    var processedData: MutableLiveData<ResponseWrapper> = MutableLiveData()

    private var observer: Observer<ResponseWrapper>? = null

    fun fetchSampleData() {
        repository.getCats(fetchedData)
        observer = Observer{ result ->
            Log.e("Sample Data Processing", "::->" + result)
            processedData.postValue(result)
        }
        fetchedData.observeForever(observer!!)
    }

    fun tearDown() {
        repository.flush()
        fetchedData.removeObserver(observer!!)
    }

}