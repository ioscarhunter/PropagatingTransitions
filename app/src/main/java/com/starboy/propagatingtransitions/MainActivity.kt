package com.starboy.propagatingtransitions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.CircularPropagation
import android.transition.TransitionPropagation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val propagation: TransitionPropagation = CircularPropagation()
    }
}
