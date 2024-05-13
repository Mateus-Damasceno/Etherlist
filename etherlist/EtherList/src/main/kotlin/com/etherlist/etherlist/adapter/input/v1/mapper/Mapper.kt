package com.etherlist.etherlist.adapter.input.v1.mapper

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.Categoria
import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.input.v1.controller.request.model.Itens
import com.etherlist.etherlist.adapter.input.v1.controller.response.EtherListResponse
import com.etherlist.etherlist.adapter.output.rest.dto.CategoriaDTO
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListRequestDTO
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListResponseDTO
import com.etherlist.etherlist.adapter.output.rest.dto.ItensDTO


fun Categoria.toDTO(): CategoriaDTO = CategoriaDTO(
    id = this.id,
    nome = this.nome
)

fun Itens.toDTO(categoriaNome: String): ItensDTO = ItensDTO(
    nome = this.nome,
    valor = this.valor,
    categoria = categoriaNome
)

fun EtherListRequest.toDTO(): EtherListRequestDTO = EtherListRequestDTO(
    id = this.id,
    itensDTO = this.itens?.mapNotNull { it?.toDTO("Categoria Padrão") }
)



fun EtherListRequestDTO.toResponse(): EtherListRequest = EtherListRequest(
    id = this.id,
    itens = this.itensDTO?.mapNotNull { it?.toResponse() }
)

fun ItensDTO.toResponse(): Itens = Itens(
    nome = this.nome,
    valor = this.valor
)

fun EtherListResponse.toDTO(): EtherListResponseDTO {
    return EtherListResponseDTO(
        id = this.id,
        etherListRequestDTO = this.etherListRequestDTO?.mapNotNull { it },
        dataCriacao = this.dataCriacao,
        dataExplosao = this.dataExplosao
    )
}


fun EtherListResponseDTO.toResponse(): EtherListResponse {
    return EtherListResponse(
        id = this.id,
        etherListRequestDTO = this.etherListRequestDTO?.mapNotNull { it },
        dataCriacao = this.dataCriacao,
        dataExplosao = this.dataExplosao
    )
}