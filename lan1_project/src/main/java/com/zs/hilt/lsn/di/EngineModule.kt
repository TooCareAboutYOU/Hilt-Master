package com.zs.hilt.lsn.di

import com.zs.hilt.lsn.di.dl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
@Module
@InstallIn(SingletonComponent::class)
interface EngineModule {

    @Binds
    @BindChinaEngine
    fun provideChinaEngine(chinaEngine: ChinaEngineImpl): Engine

    @Binds
    @BindJapanEngine
    fun provideJapanEngine(japanEngine: JapanEngineImpl): Engine
}