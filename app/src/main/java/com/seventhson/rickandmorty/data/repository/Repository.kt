package com.seventhson.rickandmorty.data.repository

import com.google.gson.Gson
import com.seventhson.rickandmorty.data.network.response.ErrorResponse
import com.seventhson.rickandmorty.utils.CustomException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

open class Repository {

    fun <T : Any> apiCall(call: suspend () -> Response<T>): Flow<T> = flow {

        val response = call.invoke()
        if (response.isSuccessful) {
            emit(response.body()!!)
        } else {
            /*
            controlar codigos de error
                    if (myResp.code() == 403){
                        CustomException(response.code(), "mensaje de error custom")
                    }

            */
            val gson = Gson()
            response.errorBody()?.let {
                val errorResponse: ErrorResponse
                try {
                    errorResponse = gson.fromJson(it.string(), ErrorResponse::class.java)
                } catch (e: Exception) {
                    throw CustomException(response.code(), "Error ${response.code()}")
                }
                errorResponse?.let {
                    throw CustomException(errorResponse.status, errorResponse.error)
                }

            }
            throw CustomException(response.code(), "Error ${response.code()}")

        }

    }

}
