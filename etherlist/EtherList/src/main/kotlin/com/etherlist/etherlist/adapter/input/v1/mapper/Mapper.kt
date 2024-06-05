package com.etherlist.etherlist.adapter.input.v1.mapper

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.Categoria
import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.input.v1.controller.request.model.Itens
import com.etherlist.etherlist.adapter.input.v1.controller.response.EtherListResponse
import com.etherlist.etherlist.adapter.output.rest.dto.CategoriaDTO
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListRequestDTO
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListResponseDTO
import com.etherlist.etherlist.adapter.output.rest.dto.ItensDTO


// Converte Categoria para CategoriaDTO
fun Categoria.toDTO(): CategoriaDTO = CategoriaDTO(
    id = this.id,
    nome = this.nome
)

// Converte Itens para ItensDTO com categoria
fun Itens.toDTO(categoriaNome: String): ItensDTO = ItensDTO(
    nome = this.nome,
    valor = this.valor,
    categoria = categoriaNome
)

// Converte EtherListRequest para EtherListRequestDTO
fun EtherListRequest.toDTO(): EtherListRequestDTO = EtherListRequestDTO(
    id = this.id,
    itensDTO = this.itens?.mapNotNull { it?.toDTO("Categoria Padrão") } // Ajustar conforme necessário
)

// Converte EtherListRequestDTO para EtherListRequest
fun EtherListRequestDTO.toResponse(): EtherListRequest = EtherListRequest(
    id = this.id,
    itens = this.itensDTO?.mapNotNull { it?.toResponse() }
)

// Converte ItensDTO para Itens
fun ItensDTO.toResponse(): Itens = Itens(
    nome = this.nome,
    valor = this.valor
)

// Converte EtherListResponse para EtherListResponseDTO
fun EtherListResponse.toDTO(): EtherListResponseDTO = EtherListResponseDTO(
    id = this.id,
    etherListRequestDTO = this.etherListRequestDTO?.mapNotNull { it?.toDTO() },
    dataCriacao = this.dataCriacao,
    dataExplosao = this.dataExplosao
)

// Converte EtherListResponseDTO para EtherListResponse
fun EtherListResponseDTO.toResponse(): EtherListResponse = EtherListResponse(
    id = this.id,
    etherListRequestDTO = this.etherListRequestDTO?.mapNotNull { it?.toDTO() },
    dataCriacao = this.dataCriacao,
    dataExplosao = this.dataExplosao
)

// Converte EtherListRequestDTO para EtherListRequestDTO
fun EtherListRequestDTO.toDTO(): EtherListRequestDTO = EtherListRequestDTO(
    id = this.id,
    itensDTO = this.itensDTO
)
