package com.example.baedal_baedal.fail

import android.util.Log

class FailMyModel(var name: String? = null, var profileImage: String? = null) {
    val TAG: String = "로그"

    init {
        Log.d(TAG, "MyModel - init() called")
    }
}