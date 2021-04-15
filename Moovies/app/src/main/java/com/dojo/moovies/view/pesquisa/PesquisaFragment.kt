package com.dojo.moovies.view.pesquisa

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

import com.dojo.moovies.view.pesquisa.adapter.SearchAdapter
import com.dojo.moovies.R
import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.data.domain.pesquisa.Pesquisa
import com.dojo.moovies.databinding.FragmentSearchBinding
import com.dojo.moovies.util.JustWatchApiData.Companion.API_PAGE_SIZE
import com.dojo.moovies.util.toLowerCase
import org.koin.android.viewmodel.ext.android.viewModel

class PesquisaFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: PesquisaViewModel by viewModel()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val searchBinding = FragmentSearchBinding.bind(view)

        initComponents(searchBinding)
    }

    override fun onResume() {
        super.onResume()
        //get populares
        val pesquisa: Pesquisa =
            Pesquisa(
                query = null,
                page = 1,
                page_size = API_PAGE_SIZE,
                content_types = listOf("show", "movie")
            )
        viewModel.search(pesquisa)
    }

    private fun initComponents(searchBinding: FragmentSearchBinding) {
        searchBinding.textInputSearch.editText?.addTextChangedListener { editable ->
            val pesquisa: Pesquisa =
                Pesquisa(
                    query = toLowerCase(editable.toString()),
                    page = 1,
                    page_size = API_PAGE_SIZE,
                    content_types = listOf("show", "movie")
                )
            viewModel.search(pesquisa)
        }
        viewModel.listSearch.observe(viewLifecycleOwner, { listSearch ->
            if (listSearch != null) {
                val searchAdapter = SearchAdapter(listSearch)
                searchBinding.rcySearchResults.apply {
                    adapter = searchAdapter
                    layoutManager = LinearLayoutManager(context)
                }

                showSearch(searchBinding)

                searchAdapter.setOnClickListener(object : MovieOnClickListener {
                    override fun onItemClick(show: Item) {
                        /*
                        val directions =
                            SearchFragmentDirections.actionSearchFragmentToDetailsFragment(show)
                        findNavController().navigate(directions)

                         */

                    }
                })
            } else {
                hideSearch(searchBinding)
            }
        })
    }

    private fun showSearch(searchBinding: FragmentSearchBinding) {
        searchBinding.rcySearchResults.visibility = View.VISIBLE
        searchBinding.tvSearchTitleResults.visibility = View.VISIBLE
        searchBinding.tvSearchNotingFound.visibility = View.GONE
    }

    private fun hideSearch(searchBinding: FragmentSearchBinding) {
        searchBinding.rcySearchResults.visibility = View.GONE
        searchBinding.tvSearchTitleResults.visibility = View.GONE
        searchBinding.tvSearchNotingFound.visibility = View.VISIBLE

    }
}