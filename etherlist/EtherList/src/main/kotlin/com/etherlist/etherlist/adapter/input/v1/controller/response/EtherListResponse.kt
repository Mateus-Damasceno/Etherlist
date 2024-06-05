package com.etherlist.etherlist.adapter.input.v1.controller.response

import com.etherlist.etherlist.adapter.output.rest.dto.EtherListRequestDTO
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class EtherListResponse(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("etherlist_id")
    var id: String? = null,

    @get:DynamoDbAttribute("etherlist_itens")
    var etherListRequestDTO: List<EtherListRequestDTO?>? = null,

    @get:DynamoDbAttribute("data_criacao")
    var dataCriacao: String? = null,

    @get:DynamoDbAttribute("data_explosao")
    var dataExplosao: String? = null
)