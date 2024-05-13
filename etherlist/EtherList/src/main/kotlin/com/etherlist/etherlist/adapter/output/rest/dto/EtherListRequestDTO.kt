package com.etherlist.etherlist.adapter.output.rest.dto

data class EtherListRequestDTO(
    var id: String,
    var itensDTO: List<ItensDTO?>?
    )