package com.zs.hilt.lsn.impl

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.zs.hilt.lsn.InetProcessor
import com.zs.hilt.lsn.callback.ICallback
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * @author zhangshuai
 * @date 2022/5/11 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
class VolleyProcessor(context: Context) : InetProcessor {

    private var mQueue: RequestQueue = Volley.newRequestQueue(context)


    init {
        Log.i("print_logs", "VolleyProcessor::constructor:init:")
    }

    override fun post(url: String, map: HashMap<String, Any>, callback: ICallback) {
        Log.i("print_logs", "VolleyProcessor::post:")
    }
}