package com.bss.codebase.service.authentication

class AuthenticationManagerConfiguration(var uniqueStorageKey: String) {
    var useStorage: Boolean = true
        private set

    fun enableStorage(): AuthenticationManagerConfiguration {
        useStorage = true;
        return this
    }

    fun disableStorage(): AuthenticationManagerConfiguration {
        useStorage = false;
        return this
    }
}