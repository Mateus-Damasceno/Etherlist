package com.etherlist.etherlist.application.service.etherlist

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.EtherListRequest
import com.etherlist.etherlist.adapter.input.v1.mapper.toDTO
import com.etherlist.etherlist.adapter.input.v1.mapper.toResponse
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListRequestDTO
import com.etherlist.etherlist.adapter.output.rest.dto.EtherListResponseDTO
import com.etherlist.etherlist.adapter.output.rest.dto.ItensDTO
import com.etherlist.etherlist.adapter.output.rest.feign.CategoriaClient
import com.etherlist.etherlist.adapter.output.rest.feign.CategoriaService
import com.etherlist.etherlist.application.ports.input.EtherlistUseCase
import com.etherlist.etherlist.application.repository.EtherListReposiory
import com.etherlist.etherlist.application.service.datahandler.DataExplosao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CreateListaEtherService(
    @Autowired private val repository: EtherListReposiory,
    @Autowired private val categoriaClient: CategoriaClient,
    @Autowired private val categoriaService: CategoriaService,
    @Autowired private val datas: DataExplosao
) : EtherlistUseCase{

    override fun saveEtherList(etherListRequests: EtherListRequest): EtherListResponseDTO? {



        val itensDTO = etherListRequests.itens?.map { item ->
            item?.let {
                ItensDTO(
                    nome = it.nome,
                    valor = it.valor,
                    categoria = categoriaService.getCategoriaAleatoria().nome
                )
            }
        }?.filterNotNull()

        val etherListRequestDTO = EtherListRequestDTO(
            id = etherListRequests.id,
            itensDTO = itensDTO
        )



        val dataCriacao = datas.criarDataLista()
        val dataCriacaoFormatada = datas.printData(dataCriacao)
        val dataExplosao = datas.criarDataExplosao(dataCriacao)

        val etherListResponseDTO = EtherListResponseDTO(
            id = etherListRequests.id,
            etherListRequestDTO = listOf(etherListRequestDTO),
            dataCriacao = dataCriacaoFormatada,
            dataExplosao = dataExplosao
        )

        val saved = repository.insert(etherListResponseDTO.toResponse())
        return saved.toDTO()
    }

    override fun getEtherList(): List<EtherListResponseDTO?>? {
        return  repository.findAll().map { it.toDTO() }
    }

}