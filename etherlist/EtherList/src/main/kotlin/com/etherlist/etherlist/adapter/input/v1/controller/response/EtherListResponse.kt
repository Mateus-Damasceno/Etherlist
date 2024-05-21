package com.etherlist.etherlist.adapter.input.v1.controller.response

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListRequestDTO
import org.springframework.data.annotation.Id
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class EtherListResponse(
    @get:DynamoDbPartitionKey
    var id: String,
    var etherListRequestDTO: List<EtherListRequestDTO?>?,
    var dataCriacao: String?,
    var dataExplosao: String?
)
