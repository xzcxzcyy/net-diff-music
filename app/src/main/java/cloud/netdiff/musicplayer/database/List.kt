package cloud.netdiff.musicplayer.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_table")
data class List(
    @PrimaryKey(autoGenerate = true)
    var listId: Long = 0,

    @ColumnInfo(name = "list_name")
    var listName: String = "",

    @ColumnInfo(name = "song_id")
    var songId: MutableList<Long> = mutableListOf<Long>(),

    @ColumnInfo(name = "list_description")
    var listDescription: String = "",

    @ColumnInfo(name = "list_cover_url")
    var listCoverUrl: String = ""
)