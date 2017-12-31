package com.werb.papillon.persistence

import android.arch.lifecycle.*
import com.werb.papillon.model.data.Shot
import com.werb.papillon.repository.ShotsRepository

/**
 * Created by wanbo on 2017/12/29.
 */
class FollowingShotsViewModel private constructor(private val shotsRepository: ShotsRepository) : ViewModel() {

    private val page = MutableLiveData<Int>()

    val shots: LiveData<List<Shot>> = Transformations.switchMap<Int, List<Shot>>(page) { input ->
        shotsRepository.requestFollowingShots(page = input) }

    var loading: LiveData<Boolean> = shotsRepository.loading()
        private set

    fun refresh() {
        page.value = 1
    }

    fun loadNextPage() {
        page.value = if (page.value == null) 1 else page.value!! + 1
    }

    class Factory(private val shotsRepository: ShotsRepository) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
                FollowingShotsViewModel(shotsRepository) as T
    }

}