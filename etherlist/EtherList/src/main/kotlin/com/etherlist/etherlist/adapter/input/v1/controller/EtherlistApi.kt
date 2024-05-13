package com.etherlist.etherlist.adapter.input.v1.controller

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

interface EtherlistApi {

    fun saveEtherList(@RequestBody etherListRequests: EtherListRequest): ResponseEntity<EtherListResponseDTO>
    fun getAllEtherData(): ResponseEntity<List<EtherListResponseDTO?>>
}