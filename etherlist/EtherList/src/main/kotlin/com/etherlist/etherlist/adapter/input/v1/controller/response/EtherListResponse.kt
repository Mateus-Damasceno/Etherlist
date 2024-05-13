package com.etherlist.etherlist.adapter.input.v1.controller.response

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListRequestDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("etherlist")
data class EtherListResponse(
    @Id
    var id: String,
    var etherListRequestDTO: List<EtherListRequestDTO?>?,
    var dataCriacao: String?,
    var dataExplosao: String?
)
