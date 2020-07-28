package cloud.netdiff.musicplayer.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cloud.netdiff.musicplayer.database.Song
import cloud.netdiff.musicplayer.databinding.ListItemSongBinding

class SongAdapter(private val clickListener: SongListener) :
    ListAdapter<Song, SongAdapter.ViewHolder>(SongDiffCallback()) {

    init {
        Log.d(TAG, "constructor: invoked ")
    }

    companion object {
        private const val TAG = "SongAdapter"
    }

    class ViewHolder private constructor(private val binding: ListItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Song, clickListener: SongListener) {
            binding.apply {
                song = item
                itemClickListener = clickListener
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSongBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder: invoked")
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: invoked")
        val item = getItem(position)

        holder.bind(item, clickListener)
    }
}

class SongDiffCallback : DiffUtil.ItemCallback<Song>() {

    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem.songId == newItem.songId
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem == newItem
    }
}

class SongListener(val clickListener: (songId: Long) -> Unit) {
    fun onClick(song: Song) = clickListener(song.songId)
}
