package com.zs.hilt.lsn.callback

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
interface ICallback {
    fun onSuccess(result: String)
    fun onError()
}
