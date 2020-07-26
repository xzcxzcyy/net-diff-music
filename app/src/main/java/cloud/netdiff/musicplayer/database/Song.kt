package cloud.netdiff.musicplayer.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song_table")
data class Song(
    @PrimaryKey(autoGenerate = true)
    var songId: Long = 0,

    @ColumnInfo(name = "song_name")
    var songName: String = "",

    @ColumnInfo(name = "singer")
    var singer: String = "",

    @ColumnInfo(name = "album")
    var album: String = "",

    @ColumnInfo(name = "favored")
    var favored: Boolean = false,

    @ColumnInfo(name = "song_url")
    var songUrl: String = ""
)