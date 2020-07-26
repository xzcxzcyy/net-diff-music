package cloud.netdiff.musicplayer.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import cloud.netdiff.musicplayer.R
import cloud.netdiff.musicplayer.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var dataBinding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)
        val myActivity = activity as AppCompatActivity
        myActivity.setSupportActionBar(dataBinding.toolbar)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
    }

}