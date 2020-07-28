package cloud.netdiff.musicplayer.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import cloud.netdiff.musicplayer.R
import cloud.netdiff.musicplayer.database.Song
import cloud.netdiff.musicplayer.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private val TAG = "ListFragment"

    private lateinit var viewModel: ListViewModel
    private lateinit var dataBinding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)
        val myActivity = activity as AppCompatActivity
        myActivity.setSupportActionBar(dataBinding.toolbar)
        dataBinding.toolbarLayout.title = "未命名歌单"

        //TODO: get list name out of database, and change the toolbar title

        val adapter = SongAdapter(SongListener {
            Log.d(TAG, "SongAdapter: item click event listened.")
        })
        dataBinding.listSongRecycler.adapter = adapter

        //TODO: Only for test here.
        val testList = mutableListOf<Song>()
        var i = 1
        while (i <= 100) {
            val t = Song(songId = i.toLong(), songName = i.toString())
            testList.add(t)
            i += 1
        }
        Log.d(TAG, "onCreateView: ${testList.toString()}")
        adapter.submitList(testList.toList())

        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
    }

}