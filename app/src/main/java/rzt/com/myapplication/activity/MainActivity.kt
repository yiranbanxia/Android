package rzt.com.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import org.jetbrains.anko.startActivity
import rzt.com.myapplication.R
import rzt.com.myapplication.annocation.Clickbehavior
import rzt.com.myapplication.annocation.LoginCheck

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private val TAG = "netease>>"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @LoginCheck
    @Clickbehavior("登录")
    fun login(v: View) {
        Log.d(TAG, "执行了登录方法")
    }

    @Clickbehavior("主页")
    fun home(v: View) {
        startActivity<OtherActivity>()
    }

    @Clickbehavior("统计")
    fun count(v: View) {
        startActivity<OtherActivity>()
    }

    @Clickbehavior("我的")
    fun mine(v: View) {
        startActivity<OtherActivity>()
    }
}
