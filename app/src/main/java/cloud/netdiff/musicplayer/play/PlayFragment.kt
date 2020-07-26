package cloud.netdiff.musicplayer.play

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import cloud.netdiff.musicplayer.R
import cloud.netdiff.musicplayer.databinding.ListFragmentBinding
import cloud.netdiff.musicplayer.databinding.PlayFragmentBinding

class PlayFragment : Fragment() {

    private lateinit var viewModel: PlayViewModel
    private lateinit var dataBinding: PlayFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.play_fragment, container, false)
        return dataBinding.root
    }


}