package com.werb.papillon.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import com.werb.papillon.api.ApiManager
import com.werb.papillon.model.data.Shot
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by wanbo on 2017/12/25.
 */
class ShotsRepository : LoadingDataSource() {

    private var shots: MutableLiveData<List<Shot>> = MutableLiveData()

    fun loading(): LiveData<Boolean> = loading

    fun requestShots(timeframe: String? = null, sort: String? = null, page: Int): LiveData<List<Shot>> {
        loading.value = true
        ApiManager.api()
                .shots(sort, timeframe, page)
                .enqueue(object : Callback<List<Shot>> {

                    override fun onFailure(call: Call<List<Shot>>?, t: Throwable?) {
                        loading.value = false
                    }

                    override fun onResponse(call: Call<List<Shot>>?, response: Response<List<Shot>>?) {
                        loading.value = false
                        response?.let {
                            if (response.isSuccessful) {
                                shots.value = it.body()
                            }
                        }
                    }

                })
        return shots
    }


}