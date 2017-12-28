package com.werb.papillon.util

import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.werb.papillon.MyApp
import com.werb.papillon.extension.string

/**
 * Created by wanbo on 2017/12/28.
 */
object ToastUtils {

    private val r = Handler(Looper.getMainLooper())
    private lateinit var tn: TN

    init {
        r.post {
            tn = TN()
        }
    }

    fun show(src: String) {
        if (TextUtils.isEmpty(src)) {
            return
        }
        r.post { tn.setText(src).show() }
        Log.d("Toast", src)
    }

    fun show(resId: Int) {
        val src: String = MyApp.instance.string(resId)
        if (TextUtils.isEmpty(src)) {
            return
        }
        show(src)
    }

    internal class TN {
        private var toast: Toast = Toast.makeText(MyApp.instance, "", Toast.LENGTH_SHORT)

        fun setText(src: String?): Toast {
            toast.setText(src)
            return toast
        }
    }

}