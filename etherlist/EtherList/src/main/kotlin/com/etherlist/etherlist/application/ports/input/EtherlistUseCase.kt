package com.etherlist.etherlist.application.ports.input

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListResponseDTO

interface EtherlistUseCase {

    fun saveEtherList(etherListRequests: EtherListRequest): EtherListResponseDTO?
    fun getEtherList(): List<EtherListResponseDTO?>?
    }