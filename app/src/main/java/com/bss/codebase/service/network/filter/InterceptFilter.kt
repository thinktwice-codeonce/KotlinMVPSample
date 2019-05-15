package com.bss.codebase.service.filter

import rx.Observable

interface InterceptFilter {

    fun <T> execute(): Observable.Transformer<T, T>

}