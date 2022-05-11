package com.zs.hilt.lsn.callback

import android.util.Log
import com.google.gson.Gson
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
abstract class HttpCallback<T> : ICallback {
    override fun onSuccess(result: String) {
        try {
            Log.i("print_logs", "HttpCallback::onSuccess: $result")
            val gson = Gson()
            val clazz: Class<*> = getT(this)
            val t: T = gson.fromJson(result, clazz) as T
            onSuccess(t)
        } catch (e: Exception) {
            Log.e("print_logs", "HttpCallback::onSuccess-error: $e")
        }

    }

    override fun onError() {
        Log.e("print_logs", "HttpCallback::onError: ")
    }

    abstract fun onSuccess(t: T)

    fun getT(obj: Any): Class<*> {
        val getType = obj.javaClass.genericSuperclass
        val actualTypeArgs: Array<Type> = (getType as ParameterizedType).actualTypeArguments
        return actualTypeArgs[0] as Class<*>
    }

}