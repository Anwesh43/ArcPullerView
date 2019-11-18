package com.anwesh.uiprojects.linkedarcpullerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.arcpullerview.ArcPullerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ArcPullerView.create(this)
    }
}
