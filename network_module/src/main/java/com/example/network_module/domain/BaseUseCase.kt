package com.example.network_module.domain

abstract class BaseUseCase<REQ, RES> {

    abstract suspend fun createUseCaseExecution(req: REQ?): RES

    suspend operator fun invoke(req: REQ?): RES = createUseCaseExecution(req)

}