package com.assignment.nvest.model

data class ResponseWrapper(
    var error: Error,
    var age :Int,
    var name: String,
    var salary: String,
    var id: String
)
