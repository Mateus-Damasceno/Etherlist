package com.etherlist.etherlist.application.repository

import com.etherlist.etherlist.adapter.input.v1.controller.response.EtherListResponse
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface EtherListRepository {
    fun save(etherListResponse: EtherListResponse)
    fun findById(id: String): EtherListResponse?
    fun deleteById(id: String)
    fun findAll(): List<EtherListResponse>
}

