package com.zs.hilt.lsn.di.dl

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject
import javax.inject.Qualifier

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindChinaEngine

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindJapanEngine

interface Engine {
    fun on()
    fun off()
}


class ChinaEngineImpl @Inject constructor() : Engine {

    init {
        Log.i("print_logs", "ChinaEngineImpl::init: ")
    }

    override fun on() {
        Log.i("print_logs", "ChinaEngine::on:")
    }

    override fun off() {
        Log.i("print_logs", "ChinaEngine::off:")
    }
}

class JapanEngineImpl @Inject constructor() : Engine {

    init {
        Log.i("print_logs", "JapanEngineImpl::init: ")
    }

    override fun on() {
        Log.i("print_logs", "JapanEngine::on:")
    }

    override fun off() {
        Log.i("print_logs", "JapanEngine::off:")
    }
}

class ChinaCar @Inject constructor(private val engine: Engine) {

    init {
        Log.i("print_logs", "ChinaCar::init:: ${engine.on()}")
    }

}

