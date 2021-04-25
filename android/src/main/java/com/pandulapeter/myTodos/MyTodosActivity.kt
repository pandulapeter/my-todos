package com.pandulapeter.myTodos

import MyTodosApp
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.pandulapeter.R

class MyTodosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.MyTodos)
        super.onCreate(savedInstanceState)
        setContent { MyTodosApp() }
    }
}