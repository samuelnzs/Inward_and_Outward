package com.example.inwardandoutward.RecyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inwardandoutward.InDocInfo
import com.example.inwardandoutward.R



class IncomingAdapter(private val incomingList : ArrayList<InDocInfo>) : RecyclerView.Adapter<IncomingAdapter.IncomingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.incoming_row_layout,
        parent, false)

        return IncomingViewHolder(itemView)
    }
    override fun getItemCount(): Int = incomingList.size

    class IncomingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imgInDoc)
        val textView1 : TextView = itemView.findViewById(R.id.lblSupplierName)
        val textView2 : TextView = itemView.findViewById(R.id.lblInDocId)
        val textView3 : TextView = itemView.findViewById(R.id.lblInShortDes)
        val textView4 : TextView = itemView.findViewById(R.id.lblInDate)
        //val textView5 : TextView = itemView.findViewById(R.id.lblInTime)
    }

    override fun onBindViewHolder(holder: IncomingViewHolder, position: Int) {
        val currentOutList = incomingList[position]

        holder.imageView.setImageResource(currentOutList.imageResources)
        holder.textView1.text = currentOutList.SupName
        holder.textView2.text = currentOutList.InId
        holder.textView3.text = currentOutList.InDocDes
        holder.textView4.text = currentOutList.InDocDate
        //holder.textView5.text = currentOutList.InDocTime
    }



}