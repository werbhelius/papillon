package com.werb.papillon.repository

import android.arch.lifecycle.MutableLiveData

/**
 * Created by wanbo on 2017/12/28.
 */
open class LoadingDataSource {

    protected var loading: MutableLiveData<Boolean> = MutableLiveData()

}