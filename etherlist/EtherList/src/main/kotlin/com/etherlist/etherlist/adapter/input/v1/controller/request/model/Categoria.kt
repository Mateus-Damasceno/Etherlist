package com.etherlist.etherlist.adapter.input.v1.controller.request.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Categoria(

    @field:JsonProperty("id")
    var id: String,
    @field:JsonProperty("nome")
    var nome: String
)
