package com.zs.hilt.lsn

import com.zs.hilt.lsn.callback.ICallback

/**
 * @author zhangshuai
 * @date 2022/5/10 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
interface InetProcessor {
    //业务的顶层设计 生命周期

    fun post(url: String, map: HashMap<String, Any>, callback: ICallback)
}