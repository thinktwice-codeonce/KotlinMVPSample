package com.bss.codebase.service.filter

interface OutputFilter<Output> {
    fun execute(): Output
}