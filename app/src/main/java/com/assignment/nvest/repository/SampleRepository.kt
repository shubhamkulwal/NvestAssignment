package com.assignment.nvest.repository


import androidx.lifecycle.MutableLiveData
import com.assignment.nvest.CreateUser
import com.assignment.nvest.base.BaseRepository
import com.assignment.nvest.model.ResponseWrapper
import com.assignment.nvest.network.APIinterface
import com.assignment.nvest.util.Constants.Companion.POST_METHOD
import javax.inject.Inject


class SampleRepository @Inject constructor(val service: APIinterface) : BaseRepository() {

    private lateinit var requestedData: MutableLiveData<ResponseWrapper>
    fun getCats(requestedData: MutableLiveData<ResponseWrapper>) {
        this.requestedData = requestedData
        val createUser = CreateUser("qwerty12653", salary = "2525", age = "25")
        networkCall(POST_METHOD, "create", createUser)
    }

    fun flush() {
        if (!disposable!!.isDisposed) {
            disposable!!.dispose()
            disposable = null
        }
    }

    override fun handleResponse(responseObj: Any) {
        if (responseObj is ResponseWrapper)
            requestedData.value = responseObj
            print("$responseObj  ")
    }

    override fun handleError(error: Throwable) {
        print("$error  ")
    }
}