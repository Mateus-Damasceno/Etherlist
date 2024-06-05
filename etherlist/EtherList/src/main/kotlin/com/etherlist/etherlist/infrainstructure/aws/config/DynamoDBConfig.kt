package com.etherlist.etherlist.infrainstructure.aws.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient
import java.net.URI

@Configuration
class DynamoDBConfig(
    @Value("\${cloud.aws.dynamodb.endpoint}") private val endpoint: String,
    @Value("\${cloud.aws.region.static}") private val region: String,
    @Value("\${cloud.aws.access-key-id}") private val accessKeyId: String,
    @Value("\${cloud.aws.secret-access-key}") private val secretAccessKeyId: String,
) {

    @Bean
    fun dynamoDbAsyncClient(): DynamoDbAsyncClient {
        return DynamoDbAsyncClient.builder()
            .region(Region.of(region))
            .endpointOverride(URI.create(endpoint))
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(
                        accessKeyId,
                        secretAccessKeyId
                    )
                )
            )
            .build()
    }

    @Bean
    fun dynamoDbEnhancedAsyncClient(): DynamoDbEnhancedAsyncClient {
        return DynamoDbEnhancedAsyncClient.builder()
            .dynamoDbClient(dynamoDbAsyncClient())
            .build()
    }

}