package cloud.netdiff.musicplayer.play

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlayViewModelFactory (
    private val application: Application,
    private val singId: Long
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayViewModel::class.java)) {
            return PlayViewModel(application, singId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}