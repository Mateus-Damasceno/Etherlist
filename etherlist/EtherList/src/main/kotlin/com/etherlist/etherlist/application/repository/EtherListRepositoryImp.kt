package com.etherlist.etherlist.application.repository

import com.etherlist.etherlist.adapter.input.v1.controller.response.EtherListResponse
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException

class EtherListRepositoryImpl(
    dynamoDbEnhancedClient: DynamoDbEnhancedClient
) : EtherListRepository {

    private val tableName = "EtherListTable"
    private val table: DynamoDbTable<EtherListResponse> = dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(EtherListResponse::class.java))

    override fun save(etherListResponse: EtherListResponse) {
        try {
            table.putItem(etherListResponse)
        } catch (e: DynamoDbException) {
            println("Failed to save item: ${e.message}")
        }
    }

    override fun findById(id: String): EtherListResponse? {
        return try {
            table.getItem(EtherListResponse(id = id))
        } catch (e: DynamoDbException) {
            println("Failed to retrieve item: ${e.message}")
            null
        }
    }

    override fun deleteById(id: String) {
        try {
            table.deleteItem(EtherListResponse(id = id))
        } catch (e: DynamoDbException) {
            println("Failed to delete item: ${e.message}")
        }
    }

    override fun findAll(): List<EtherListResponse> {
        return try {
            table.scan().items().toList()
        } catch (e: DynamoDbException) {
            println("Failed to retrieve items: ${e.message}")
            emptyList()
        }
    }
}