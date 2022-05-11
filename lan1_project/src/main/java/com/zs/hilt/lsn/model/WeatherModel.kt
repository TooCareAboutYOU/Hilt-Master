package com.zs.hilt.lsn.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
@Parcelize
data class Weather(
    var error_code: Int = 0,
    var reason: String = "",
    var result: Result = Result()
) : Parcelable

@Parcelize
data class Result(
    var city: String = "",
    var future: List<Future> = listOf(),
    var realtime: Realtime = Realtime()
) : Parcelable

@Parcelize
data class Future(
    var date: String = "",
    var direct: String = "",
    var temperature: String = "",
    var weather: String = "",
    var wid: Wid = Wid()
) : Parcelable

@Parcelize
data class Realtime(
    var aqi: String = "",
    var direct: String = "",
    var humidity: String = "",
    var info: String = "",
    var power: String = "",
    var temperature: String = "",
    var wid: String = ""
) : Parcelable

@Parcelize
data class Wid(
    var day: String = "",
    var night: String = ""
) : Parcelable