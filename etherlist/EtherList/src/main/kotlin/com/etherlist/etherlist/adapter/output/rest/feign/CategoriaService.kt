package com.etherlist.etherlist.adapter.output.rest.feign

import com.etherlist.etherlist.adapter.input.v1.controller.request.model.Categoria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    @Autowired val categoria: CategoriaClient
) : CategoriaClient {
    override fun getCategorias(): List<Categoria> {
        return categoria.getCategorias()
    }

    fun getCategoriaAleatoria(): Categoria {
        val categorias = categoria.getCategorias()
        if (categorias.isEmpty()) {
            throw IllegalStateException("Não há categorias disponíveis")
        }
        return categorias.random()
    }
}