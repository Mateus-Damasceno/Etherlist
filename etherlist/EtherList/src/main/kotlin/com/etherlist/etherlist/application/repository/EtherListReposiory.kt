package com.etherlist.etherlist.application.repository

import com.etherlist.etherlist.adapter.input.v1.controller.response.EtherListResponse
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EtherListReposiory: MongoRepository<EtherListResponse, String> {

    fun insert(etherListResponse: EtherListResponse):EtherListResponse

}

