package cloud.netdiff.musicplayer.title


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import cloud.netdiff.musicplayer.R
import cloud.netdiff.musicplayer.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    companion object {
        fun newInstance() = TitleFragment()
    }

    private lateinit var viewModel: TitleViewModel
    private lateinit var dataBinding: TitleFragmentBinding
    private lateinit var adapter: TitleAdapter

    val titleList = ArrayList<Title>()


    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.title_fragment, container, false)
        var view1: View? = null
        var view2: View? = null
        lateinit var viewPager: ViewPager
        var viewList: List<View>? = null
        viewPager = dataBinding.pager
        val inflater = layoutInflater
        view1 = inflater.inflate(R.layout.title_local_fragment, null)
        view2 = inflater.inflate(R.layout.title_online_fragment, null)

        viewList = ArrayList()

        viewList.add(view1!!)
        viewList.add(view2!!)

        val pagerAdapter: PagerAdapter = object : PagerAdapter() {
            override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
                return arg0 == arg1
            }

            override fun getCount(): Int {
                return viewList.size
            }

            override fun destroyItem(
                container: ViewGroup, position: Int,
                `object`: Any
            ) {
                container.removeView(viewList[position])
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                container.addView(viewList[position])
                return viewList[position]
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

        return dataBinding.root

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        initTitles()
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        dataBinding.local.layoutManager = layoutManager
        adapter = TitleAdapter(this,titleList)
        dataBinding.local.adapter = adapter
    }

    private fun initTitles(){
        titleList.clear()
        titleList.apply {
            add(Title("我的音乐",R.drawable.title1))
            add(Title(" 歌单",R.drawable.songlist))
            add(Title("网难云",R.drawable.wangyiyun))
            add(Title(" 电台",R.drawable.radio))
            add(Title(" wifi",R.drawable.wifi))
            add(Title(" 专辑",R.drawable.disc))
            add(Title("排行榜",R.drawable.sort))
        }
    }

}