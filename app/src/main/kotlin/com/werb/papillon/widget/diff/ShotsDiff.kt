package com.werb.papillon.widget.diff

import com.werb.library.link.XDiffCallback
import com.werb.papillon.model.data.Shot

/**
 * Created by wanbo on 2017/12/30.
 */
class ShotsDiff(oldItem: List<Any>, newItem: List<Any>) : XDiffCallback(oldItem, newItem) {

    override fun getNewListSize(): Int = newItem.size

    override fun getOldListSize(): Int = oldItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldItem[oldItemPosition]
        val new = newItem[newItemPosition]
        if (old is Shot && new is Shot) {
            return old.id == new.id
        }

        return false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldItem[oldItemPosition]
        val new = newItem[newItemPosition]
        if (old is Shot && new is Shot) {
            return old.likes_count == new.likes_count && old.comments_count == new.comments_count
        }

        return false
    }

}