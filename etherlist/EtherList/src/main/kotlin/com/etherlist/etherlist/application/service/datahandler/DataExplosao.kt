package com.etherlist.etherlist.application.service.datahandler

import org.springframework.stereotype.Component
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Component
class DataExplosao {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault())

    fun criarDataLista(): ZonedDateTime {
        // Converte o Instant para ZonedDateTime usando a zona horária do sistema
        return Instant.now().atZone(ZoneId.systemDefault())
    }

    fun formatarData(zonedDateTime: ZonedDateTime): String {
        // Formata o ZonedDateTime para String usando o padrão definido
        return formatter.format(zonedDateTime)
    }

    fun criarDataExplosao(zonedDateTime: ZonedDateTime): String {
        // Adiciona 24 horas ao ZonedDateTime
        val dataExplosao = zonedDateTime.plusSeconds(86400) // 86400 segundos = 24 horas
        return formatarData(dataExplosao)
    }

    fun printData(data :ZonedDateTime):String{
        return formatarData(data)
    }
}