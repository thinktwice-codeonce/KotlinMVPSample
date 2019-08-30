package com.bss.codebase.app.service.authentication

import com.bss.codebase.service.network.provider.NetworkProvider

class DefaultAuthenticationService(val networkProvider: NetworkProvider,
                                   val restAuthenticationService: RestAuthenticationService): AuthenticationService {


}