package com.example.moovies

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dojo.model.Item
import com.example.moovies.extension.firstItemTitle
import com.example.moovies.viewmodel.JustWatchViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        val justWatchViewModel = ViewModelProvider(this).get(JustWatchViewModel::class.java)
        justWatchViewModel.populares.observe(this, Observer {
            println(it?.firstItemTitle())
        })

        filmesESeriesSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                println(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                println(newText)
                return false
            }
        })
    }
}

