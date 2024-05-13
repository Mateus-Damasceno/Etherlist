package com.etherlist.etherlist.adapter.output.rest.feign


import com.etherlist.etherlist.adapter.input.v1.controller.request.model.Categoria
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
@FeignClient(name = "categoriaClient", url = "http://localhost:1080")
interface CategoriaClient {
    @GetMapping("/etherlist/categoria")
    fun getCategorias(): List<Categoria>
}