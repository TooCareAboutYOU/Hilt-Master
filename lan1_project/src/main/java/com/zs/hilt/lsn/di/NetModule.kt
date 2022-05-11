package com.zs.hilt.lsn.di

import android.app.Application
import android.content.Context
import android.util.Log
import com.zs.hilt.lsn.impl.OkHttpProcessor
import com.zs.hilt.lsn.manager.HttpHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.modules.ApplicationContextModule
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
@Module(includes = [ApplicationContextModule::class])
@InstallIn(value = [SingletonComponent::class])
object NetModule {

    @Provides
    @Singleton
    fun provideOkHttpProcessor(application: Application): HttpHelper {
        Log.i("print_logs", "NetModule::provideOkHttpProcessor:")
        return HttpHelper.instance().apply {
            init(OkHttpProcessor(application))
        }
    }
}