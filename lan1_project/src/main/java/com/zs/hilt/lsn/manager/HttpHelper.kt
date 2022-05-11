package com.zs.hilt.lsn.manager

import android.util.Log
import com.zs.hilt.lsn.InetProcessor
import com.zs.hilt.lsn.callback.ICallback
import java.net.URLEncoder.encode

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
class HttpHelper private constructor() : InetProcessor {

    private var mInetProcessor: InetProcessor? = null

    companion object {
        private var instance: HttpHelper? = null
            get() {
                if (field == null) {
                    instance = HttpHelper()
                }
                return field
            }

        @Synchronized
        fun instance(): HttpHelper {
            return instance!!
        }
    }

    fun init(inetProcessor: InetProcessor) {
        this.mInetProcessor = inetProcessor
    }


    override fun post(url: String, map: HashMap<String, Any>, callback: ICallback) {
        val finalUrl: String = appendParams(url, map)
        mInetProcessor?.post(finalUrl, map, callback)
    }


    private fun appendParams(url: String, map: HashMap<String, Any>): String {
        if (map != null && map.isEmpty()) {
            val stringBuilder = StringBuilder(url)
            if (stringBuilder.indexOf("?") <= 0) {
                stringBuilder.append("?")
            } else {
                if (!stringBuilder.toString().endsWith("?")) {
                    stringBuilder.append("&")
                }
            }

            map.forEach {
                stringBuilder.append("&" + it.key).append("=").append(encode(it.value.toString()))
            }

            return stringBuilder.toString()
        }

        return url
    }

}