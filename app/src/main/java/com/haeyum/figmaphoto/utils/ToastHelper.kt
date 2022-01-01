package com.haeyum.figmaphoto.utils

import android.widget.Toast
import com.haeyum.figmaphoto.MainApp

object ToastHelper {
    fun showToast(msg: String) = Toast.makeText(MainApp.context, msg, Toast.LENGTH_SHORT).show()
}