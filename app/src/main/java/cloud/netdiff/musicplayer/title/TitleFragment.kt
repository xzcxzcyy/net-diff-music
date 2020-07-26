package cloud.netdiff.musicplayer.title


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import cloud.netdiff.musicplayer.R
import cloud.netdiff.musicplayer.databinding.ListFragmentBinding
import cloud.netdiff.musicplayer.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    companion object {
        fun newInstance() = TitleFragment()
    }

    private lateinit var viewModel: TitleViewModel
    private lateinit var dataBinding: TitleFragmentBinding

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
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)


    }

}