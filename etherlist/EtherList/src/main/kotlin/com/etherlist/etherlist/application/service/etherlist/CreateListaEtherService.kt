package com.etherlist.etherlist.application.service.etherlist

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.input.v1.controller.response.EtherListResponse
import com.etherlist.etherlist.adapter.input.v1.mapper.toDTO
import com.etherlist.etherlist.adapter.input.v1.mapper.toResponse
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListRequestDTO
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListResponseDTO
import com.etherlist.etherlist.adapter.output.rest.dto.ItensDTO
import com.etherlist.etherlist.adapter.output.rest.feign.CategoriaClient
import com.etherlist.etherlist.adapter.output.rest.feign.CategoriaService
import com.etherlist.etherlist.application.ports.input.EtherlistUseCase
import com.etherlist.etherlist.application.repository.EtherListRepository
import com.etherlist.etherlist.application.service.datahandler.DataExplosao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CreateListaEtherService(
    @Autowired  private val repository: EtherListRepository,
    @Autowired private val categoriaClient: CategoriaClient,
    @Autowired private val categoriaService: CategoriaService,
    @Autowired private val datas: DataExplosao
) : EtherlistUseCase{

    override fun saveEtherList(etherListRequests: EtherListRequest): EtherListResponseDTO? {
        // Mapeia os itens de EtherListRequest para ItensDTO
        val itensDTO = etherListRequests.itens?.mapNotNull { item ->
            item?.let {
                ItensDTO(
                    nome = it.nome,
                    valor = it.valor,
                    categoria = categoriaService.getCategoriaAleatoria().nome
                )
            }
        }

        // Cria EtherListRequestDTO com os itens mapeados
        val etherListRequestDTO = EtherListRequestDTO(
            id = etherListRequests.id,
            itensDTO = itensDTO
        )

        // Gera datas de criação e explosão
        val dataCriacao = datas.criarDataLista()
        val dataCriacaoFormatada = datas.printData(dataCriacao)
        val dataExplosao = datas.criarDataExplosao(dataCriacao)

        // Cria EtherListResponseDTO com os dados gerados e mapeados
        val etherListResponseDTO = EtherListResponseDTO(
            id = etherListRequests.id,
            etherListRequestDTO = listOf(etherListRequestDTO),
            dataCriacao = dataCriacaoFormatada,
            dataExplosao = dataExplosao
        )

        // Converte EtherListResponseDTO para EtherListResponse e salva no repositório
        val saved = repository.save(etherListResponseDTO.toResponse())

        // Converte o objeto salvo de volta para EtherListResponseDTO e o retorna
        return null
    }

    override fun getEtherList(): List<EtherListResponseDTO?>? {
        return  repository.findAll().map { it.toDTO() }
    }

}