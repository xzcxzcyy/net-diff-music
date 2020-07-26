package cloud.netdiff.musicplayer

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager


class MainActivity : AppCompatActivity() {

    private var view1: View? = null
    private var view2: View? = null
    private lateinit var viewPager: ViewPager
    private var viewList: List<View>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //去掉状态栏

        //去掉状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            decorView.systemUiVisibility = option
            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        }

        viewPager = findViewById(R.id.pager)
        val inflater = layoutInflater
        view1 = inflater.inflate(R.layout.title_local_fragment, null)
        view2 = inflater.inflate(R.layout.title_online_fragment, null)

        viewList = ArrayList()

        (viewList as ArrayList<View>).add(view1!!)
        (viewList as ArrayList<View>).add(view2!!)

        //传递viewList出了点问题，先暂且直接放在activity下

        var pagerAdapter: PagerAdapter = object : PagerAdapter() {
            override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
                return arg0 == arg1
            }

            override fun getCount(): Int {
                return viewList!!.size
            }

            override fun destroyItem(
                container: ViewGroup, position: Int,
                `object`: Any
            ) {
                container.removeView(viewList!![position])
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                container.addView(viewList!![position])
                return viewList!![position]
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return when (position) {
                    0 -> "本地音乐"
                    1 -> "在线搜索"
                    else -> "Title default"
                }
            }


        }

        viewPager.adapter = pagerAdapter

    }


}