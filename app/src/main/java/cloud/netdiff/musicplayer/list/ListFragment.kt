package cloud.netdiff.musicplayer.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import cloud.netdiff.musicplayer.R
import cloud.netdiff.musicplayer.databinding.ListFragmentBinding
import java.util.zip.Inflater

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var dataBinding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = ListFragmentBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
    }

}