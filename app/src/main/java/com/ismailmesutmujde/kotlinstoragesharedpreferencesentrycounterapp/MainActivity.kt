package com.ismailmesutmujde.kotlinstoragesharedpreferencesentrycounterapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesharedpreferencesentrycounterapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences("EntryCounter", Context.MODE_PRIVATE)

        var counter = sharedPreferences.getInt("counter", 0)

        val editor = sharedPreferences.edit()
        editor.putInt("counter", ++counter)
        editor.commit()

        bindingMain.textViewCounter.text = "Entry Counter : $counter"

    }
}