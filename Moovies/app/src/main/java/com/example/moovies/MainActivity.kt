package com.example.moovies

import android.nfc.tech.MifareUltralight
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dojo.model.Resultado
import com.example.moovies.layout.ItemAdapter
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
        carregarPopulares(justWatchViewModel)
        preparaSearchView(justWatchViewModel)

    }


    private fun preparaSearchView(justWatchViewModel: JustWatchViewModel) {
        filmesESeriesSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                adaptarVisibilidadeBuscaIniciada()
                justWatchViewModel.resultadoPesquisa(query, 1, null).observe(this@MainActivity,
                    Observer { prepararListaDeFilmes(it) })
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adaptarVisibilidadeBuscaIniciada()
                Handler().postDelayed(Runnable {
                    justWatchViewModel.resultadoPesquisa(newText, 1, null)
                        .observe(this@MainActivity,
                            Observer { prepararListaDeFilmes(it) })

                }, 1700)
                return false
            }
        })
    }

    private fun carregarPopulares(justWatchViewModel: JustWatchViewModel) {
        adaptarVisibilidadeBuscaIniciada()
        justWatchViewModel.populares.observe(this, Observer {
            prepararListaDeFilmes(it)
        })
    }

    private fun prepararListaDeFilmes(resultado: Resultado?) {
        recycler_view.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val itemAdapter: ItemAdapter = ItemAdapter(resultado?.items)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = itemAdapter

        adaptarVisibilidadeBuscaConcluida()
    }


    private fun adaptarVisibilidadeBuscaConcluida() {
        progressBar.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
    }

    private fun adaptarVisibilidadeBuscaIniciada() {
        progressBar.visibility = View.VISIBLE
        recycler_view.visibility = View.GONE
    }


}



