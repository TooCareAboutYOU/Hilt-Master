package com.zs.hilt.lsn.impl

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.zs.hilt.lsn.InetProcessor
import com.zs.hilt.lsn.callback.ICallback
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.*
import java.io.IOException
import kotlin.collections.HashMap

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
class OkHttpProcessor(@ApplicationContext private val context: Context) : InetProcessor {

    init {
        Log.i("print_logs", "OkHttpProcessor::constructor:init:")
    }

    private var client: OkHttpClient.Builder = OkHttpClient.Builder()
    private var mHandler: Handler = Handler(Looper.getMainLooper())

    override fun post(url: String, map: HashMap<String, Any>, callback: ICallback) {
        Log.i("print_logs", "OkHttpProcessor::post:")
//        request(url, map, callback)
        Toast.makeText(context, "点击成功", Toast.LENGTH_SHORT).show()
    }

    private fun request(url: String, map: HashMap<String, Any>, callback: ICallback) {
        val requestBody = appendBody(map)
        val request: Request? = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()
        val okHttpClient = client.addInterceptor {
            it.proceed(it.request()).apply {
                Log.i("print_logs", "OkHttpProcessor::post: ${code()}, ${request()}")
            }
        }.build()


        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                callback.onError()
                e.printStackTrace()
                Log.i("print_logs", "OkHttpProcessor::onFailure: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body().toString()
                    mHandler.post {
                        callback.onSuccess(body)
                    }
                }
            }
        })
    }

    private fun appendBody(params: HashMap<String, Any>?): RequestBody {
        val body: FormBody.Builder = FormBody.Builder()
        if (params == null || params.isEmpty()) {
            return body.build()
        }
        params?.forEach {
            body.add(it.key, it.value.toString())
        }
        return body.build()
    }
}