package com.dojo.moovies.view.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dojo.moovies.R
import com.dojo.moovies.data.domain.detalhe.Offers
import com.dojo.moovies.data.domain.detalhe.Scoring
import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.databinding.FragmentDetailsBinding
import com.dojo.moovies.extensions.layoutHorizontal
import com.dojo.moovies.util.JustWatchApiData
import com.dojo.moovies.util.JustWatchApiData.Companion.API_LANGUAGE
import com.dojo.moovies.util.JustWatchApiData.Companion.API_SOCORING_TYPE
import com.dojo.moovies.view.details.adapter.ProviderAdapter
import com.dojo.moovies.view.interfaces.OffersOnClickListener
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList


class DetalhesFragment : Fragment(R.layout.fragment_details) {

    private val viewModel: DetalhesViewModel by viewModel()
    private val args: DetalhesFragmentArgs by navArgs()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val detailsBinding = FragmentDetailsBinding.bind(view)
        initComponents(detailsBinding)
    }

    private fun initComponents(detailsBinding: FragmentDetailsBinding) {
        detailsBinding.ibDetailsBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val item: Item = args.show
        when {
            item.object_type.equals("movie") -> viewModel.movieDetails(
                language = API_LANGUAGE,
                id = item.id.toString()
            )
            item.object_type.equals("show") -> viewModel.showDetails(
                language = API_LANGUAGE,
                id = item.id.toString()
            )
        }

        viewModel.detalheShow.observe(viewLifecycleOwner, { detalhe ->
            //preparar informacoes
            val scoringVotes: List<Scoring>? =
                detalhe?.scoring?.filter {
                    it.provider_type.equals(
                        API_SOCORING_TYPE
                    )
                }

            detailsBinding.tvDetailsTitleMovie.text = detalhe?.title
            detailsBinding.tvDetailsValueRatingMovie.text = scoringVotes?.first()?.value.toString()
            detailsBinding.tvDetailsYearMovie.text = detalhe?.original_release_year.toString()
            detailsBinding.tvDetailsDescriptionMovie.text = detalhe?.short_description

            //preparar poster
            Picasso.get()
                .load(JustWatchApiData.recuperarUrlDetalhe(detalhe))
                .into(detailsBinding.ivDetailsPosterMovie)


            //preparar servicos de stream
            var listProviders: ArrayList<Offers> = ArrayList()
            if (detalhe?.offers != null) {
                listProviders = ArrayList(detalhe.offers)
            }
            val providerAdapter = ProviderAdapter(listProviders)

            providerAdapter.setOnClickListener(object : OffersOnClickListener {
                override fun onItemClick(provider: Offers) {
                    //logica para redirecionamento

                    val viewIntent = Intent(
                        "android.intent.action.VIEW",
                        Uri.parse(provider.urls.standard_web)
                    )
                    startActivity(viewIntent)
                }
            })

            if (listProviders.isNullOrEmpty()) {
                detailsBinding.tvDetailsProviders.visibility = View.GONE
                detailsBinding.rcyDetailsProviders.visibility = View.GONE
            } else {
                detailsBinding.tvDetailsProviders.visibility = View.VISIBLE
                detailsBinding.rcyDetailsProviders.apply {
                    visibility = View.VISIBLE
                    adapter = providerAdapter
                    layoutManager = this.layoutHorizontal()
                }
            }

        })


    }


}