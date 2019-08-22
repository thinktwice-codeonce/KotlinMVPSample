package com.bss.codebase.service.network.filter

import com.bss.codebase.exception.ApiThrowable
import com.bss.codebase.exception.ErrorCodes
import com.bss.codebase.models.ServiceResultError
import com.bss.codebase.service.common.MessageResponse
import com.bss.codebase.service.common.RestMessageResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException
import rx.Observable
import java.util.ArrayList


class ApiThrowableFilter<T> : Filter<Throwable, Observable<T>> {

    fun onHandleFailedResponse(responseCode: Int, rawString: String): ApiThrowable {
        var exception: ApiThrowable
        try {
            val gson = Gson()
            val collectionType = object : TypeToken<RestMessageResponse<T>>() {}.type
            val responseMessage = gson.fromJson<RestMessageResponse<T>>(rawString, collectionType)

            val errors = responseMessage.getErrors()
            if (errors == null || errors!!.size == 0) {
                try {
                    val messageResponse = gson.fromJson<MessageResponse>(rawString, MessageResponse::class.java)
                    exception = ApiThrowable.from(responseCode, messageResponse.getMessage()!!)
                } catch (ex: Exception) {
                    exception = ApiThrowable.from(responseCode, rawString)
                }

            } else {
                var serviceResultErrors = ArrayList<ServiceResultError>()
                for (error in errors!!) {
                    serviceResultErrors.add(ServiceResultError(error.getErrorCode(), error.getErrorMessage()!!))
                }

                exception = ApiThrowable.from(serviceResultErrors)
            }
        } catch (e: Exception) {
            exception = ApiThrowable.from(e)
        }

        return exception
    }

    override fun execute(throwable: Throwable): Observable<T> {

        if (throwable is HttpException) {
            val failedResponse = throwable.response().errorBody()
            val responseCode = throwable.response().code()

            if (failedResponse == null) {
                return Observable.error(
                    ApiThrowable.from(
                        responseCode,
                        "Response Error Body is empty"
                    )
                )
            } else {
                var rawString = ""
                try {
                    rawString = failedResponse.string()
                    return Observable.error(onHandleFailedResponse(responseCode, rawString))
                } catch (ex: Exception) {
                    return Observable
                        .error(ApiThrowable.from(ErrorCodes.GENERAL_ERROR, rawString, ex))
                }

            }
        }
        return Observable.error(throwable)
    }
}