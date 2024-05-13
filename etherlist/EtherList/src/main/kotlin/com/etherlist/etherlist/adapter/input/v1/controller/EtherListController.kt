package com.etherlist.etherlist.adapter.input.v1.controller

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListResponseDTO
import com.etherlist.etherlist.application.service.etherlist.CreateListaEtherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping("/etherlist")
class EtherListController (
    @Autowired
    private val service: CreateListaEtherService
): EtherlistApi{
    @PostMapping("/save")
    override fun saveEtherList(@RequestBody etherListRequests: EtherListRequest): ResponseEntity<EtherListResponseDTO> {
        val savedEtherListDto = service.saveEtherList(etherListRequests)
        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedEtherListDto?.id)
            .toUri()

        return ResponseEntity.created(location).body(savedEtherListDto)
    }
    @GetMapping("/all")
    override fun getAllEtherData(): ResponseEntity<List<EtherListResponseDTO?>> {
        val allDataDTOs = service.getEtherList()
        return ResponseEntity.ok(allDataDTOs)
    }


}

