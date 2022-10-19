package com.example.zoo.infrastructure.configuration

import com.example.zoo.application.CreateZoneUseCase
import com.example.zoo.application.CreateZoneUseCaseImp
import com.example.zoo.application.CreateZooUseCase
import com.example.zoo.application.CreateZooUseCaseImp
import com.example.zoo.application.GetZooUseCase
import com.example.zoo.application.GetZooUseCaseImp
import com.example.zoo.domain.ZoneRepository
import com.example.zoo.domain.ZooIdentitySequencer
import com.example.zoo.domain.ZooImp
import com.example.zoo.domain.ZooRepositoryReader
import com.example.zoo.domain.ZooRepositoryWriter
import com.example.zoo.infrastructure.repository.InMemoryZooIdentitySequencer
import com.example.zoo.infrastructure.repository.InMemoryZooImpRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class Configuration {
    @Bean
    fun getCreateZooUseCase(
        zooIdentitySequencer: ZooIdentitySequencer,
        zooRepositoryWriter: ZooRepositoryWriter<ZooImp>
    ): CreateZooUseCase =
        CreateZooUseCaseImp(zooIdentitySequencer, zooRepositoryWriter)

    @Bean
    fun getZooIdentitySequencer() = InMemoryZooIdentitySequencer()

    @Bean
    @Primary
    fun getZooRepositoryWriter(): ZooRepositoryWriter<ZooImp> = InMemoryZooImpRepository(mutableMapOf())

    @Bean
    fun getZooRepositoryReader(zooRepositoryWriter: ZooRepositoryWriter<ZooImp>): ZooRepositoryReader =
        zooRepositoryWriter as InMemoryZooImpRepository

    @Bean
    fun getGetZooUseCase(zooRepositoryReader: ZooRepositoryReader): GetZooUseCase =
        GetZooUseCaseImp(zooRepositoryReader)

    @Bean
    fun getZoneRepository(zooRepositoryWriter: ZooRepositoryWriter<ZooImp>): ZoneRepository =
        zooRepositoryWriter as InMemoryZooImpRepository

    @Bean
    fun getCreateZoneUseCase(
        zoneRepository: ZoneRepository,
        zooRepositoryReader: ZooRepositoryReader
    ): CreateZoneUseCase =
        CreateZoneUseCaseImp(zoneRepository, zooRepositoryReader)
}
