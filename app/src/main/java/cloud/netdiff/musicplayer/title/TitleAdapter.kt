package cloud.netdiff.musicplayer.title

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import cloud.netdiff.musicplayer.R

class TitleAdapter(private val fragment:Fragment, private val titleList: List<Title>):
    RecyclerView.Adapter<TitleAdapter.ViewHolder>(){


   inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
       val titleImage:ImageView= view.findViewById(R.id.titleImage)
       val titleText: TextView = view.findViewById(R.id.titleText)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.title_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = titleList[position]
        holder.titleText.text = title.name
        holder.titleImage.setImageResource(title.imageId)
    }

    override fun getItemCount() = titleList.size

}