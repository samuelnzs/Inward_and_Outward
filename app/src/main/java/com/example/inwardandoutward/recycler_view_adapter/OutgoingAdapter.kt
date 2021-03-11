package com.example.inwardandoutward.recycler_view_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inwardandoutward.OutDocInfo
import com.example.inwardandoutward.R

class OutgoingAdapter(private val outgoingList : ArrayList<OutDocInfo>) : RecyclerView.Adapter<OutgoingAdapter.OutgoingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OutgoingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.outgoing_row_layout,
            parent, false)

        return OutgoingViewHolder(itemView)
    }

    override fun getItemCount(): Int = outgoingList.size

    class OutgoingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imgOutDoc)
        val textView1 : TextView = itemView.findViewById(R.id.lblCustomerName)
        val textView2 : TextView = itemView.findViewById(R.id.lblOutDocId)
        val textView3 : TextView = itemView.findViewById(R.id.lblOutShortDes)
        val textView4 : TextView = itemView.findViewById(R.id.lblOutDate)
        val textView5 : TextView = itemView.findViewById(R.id.lblOutTime)
    }



    override fun onBindViewHolder(holder: OutgoingViewHolder, position: Int) {
        val currentOutList = outgoingList[position]

        holder.imageView.setImageResource(currentOutList.imageResources)
        holder.textView1.text = currentOutList.CustName
        holder.textView2.text = currentOutList.OutId
        holder.textView3.text = currentOutList.OutDocDes
        holder.textView4.text = currentOutList.OutDocDate
        holder.textView5.text = currentOutList.OutDocTime

    }

}