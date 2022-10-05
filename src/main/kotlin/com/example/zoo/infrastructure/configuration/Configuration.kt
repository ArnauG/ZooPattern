package com.example.zoo.infrastructure.configuration

import com.example.zoo.application.CreateZooUseCaseImp
import com.example.zoo.application.CreateZooUseCase
import com.example.zoo.application.GetZooUseCase
import com.example.zoo.application.GetZooUseCaseImp
import com.example.zoo.domain.ZooIdentitySequencer
import com.example.zoo.domain.ZooRepository
import com.example.zoo.infrastructure.repository.InMemoryZooIdentitySequencer
import com.example.zoo.infrastructure.repository.InMemoryZooRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {
    @Bean
    fun getCreateZooUseCase(zooIdentitySequencer: ZooIdentitySequencer, zooRepository: ZooRepository): CreateZooUseCase =
        CreateZooUseCaseImp(zooIdentitySequencer, zooRepository)

    @Bean
    fun getZooIdentitySequencer() = InMemoryZooIdentitySequencer()

    @Bean
    fun getZooRepository() = InMemoryZooRepository(mutableMapOf())

    @Bean
    fun getGetZooUseCase(zooRepository: ZooRepository): GetZooUseCase =
        GetZooUseCaseImp(zooRepository)

}