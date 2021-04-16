package com.dojo.moovies.data.domain.detalhe

import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin com.dojo.moovies.data.domain.canais.Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class DetalheShow (

	@SerializedName("jw_entity_id") val jw_entity_id : String,
	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("full_path") val full_path : String,
	@SerializedName("full_paths") val full_paths : FullPath,
	@SerializedName("poster") val poster : String,
	@SerializedName("poster_blur_hash") val poster_blur_hash : String,
	@SerializedName("backdrops") val backdrops : List<Backdrops>,
	@SerializedName("short_description") val short_description : String,
	@SerializedName("original_release_year") val original_release_year : Int,
	@SerializedName("object_type") val object_type : String,
	@SerializedName("original_title") val original_title : String,
	@SerializedName("offers") val offers : List<Offers>,
	@SerializedName("scoring") val scoring : List<Scoring>,
	@SerializedName("credits") val credits : List<Credits>,
	@SerializedName("external_ids") val external_ids : List<ExternalIds>,
	@SerializedName("genre_ids") val genre_ids : List<Int>,
	@SerializedName("age_certification") val age_certification : String,
	@SerializedName("runtime") val runtime : Int,
	@SerializedName("production_countries") val production_countries : List<String>
)