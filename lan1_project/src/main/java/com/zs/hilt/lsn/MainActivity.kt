package com.zs.hilt.lsn

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zs.hilt.lsn.callback.HttpCallback
import com.zs.hilt.lsn.di.dl.BindChinaEngine
import com.zs.hilt.lsn.di.dl.ChinaEngineImpl
import com.zs.hilt.lsn.di.dl.Engine
import com.zs.hilt.lsn.manager.HttpHelper
import com.zs.hilt.lsn.model.Weather
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val url = "http://apis.juhe.cn/simpleWeather/query"

    @Inject
    lateinit var okHttpHelper: HttpHelper

    @Inject
    @BindChinaEngine
    lateinit var mChinaEngine: Engine

    @Inject
    lateinit var chinaCar: ChinaEngineImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //接口每天只能使用10次
    fun clickApi(view: View) {
        chinaCar.on()
        mChinaEngine.off()

        val map = HashMap<String, Any>()
            .apply {
                put("key", "20298840e6ca2cfb26c85c5c818d0368")
                put("city", "上海")
            }

        okHttpHelper.post(url, map, object : HttpCallback<Weather>() {
            override fun onSuccess(t: Weather) {
                Log.i("print_logs", "MainActivity::onSuccess: $t")
            }
        })
    }
}