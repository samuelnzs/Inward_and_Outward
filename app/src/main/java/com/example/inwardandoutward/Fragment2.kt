package com.example.inwardandoutward

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inwardandoutward.recycler_view_adapter.OutgoingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Fragment2 : Fragment(){

    lateinit var recycle : RecyclerView
    private val list = ArrayList<OutDocInfo>()
    private val adapter: OutgoingAdapter = OutgoingAdapter(list)
    private val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd  HH:mm:ss")
    private val currentDateAndTime: String = simpleDateFormat.format(Date())

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2_layout, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        recycle = view. findViewById(R.id.rcyOutgoingDoc)
        val adapter = OutgoingAdapter(list)
        recycle.layoutManager = LinearLayoutManager(activity)
        recycle.adapter = adapter

        val addButton: FloatingActionButton = view.findViewById<FloatingActionButton>(R.id.addOutDoc)

        addButton.setOnClickListener{
            val dialogView : View = LayoutInflater.from(context).inflate(R.layout.add_outdoc,null)
            val builder : AlertDialog.Builder? =
                    context?.let { it1 -> AlertDialog.Builder(it1).setView(dialogView).setTitle("Add Outgoing Document") }
            val alert : AlertDialog = builder!!.show()

            val addButton: Button =  dialogView.findViewById(R.id.btnOutAdd)
            addButton.setOnClickListener{
                alert.dismiss()
                val custName = dialogView.findViewById<EditText>(R.id.customerName)
                val desc = dialogView.findViewById<EditText>(R.id.OutDescription)

                list.add(OutDocInfo(R.drawable.out_document, custName.text.toString(), list[list.size-1].OutId+1, desc.text.toString(),currentDateAndTime))


            }
        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){

            override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
            ): Boolean{
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if(direction== ItemTouchHelper.RIGHT){
                    adapter.removeItem(viewHolder)
                }
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recycle)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list.add(OutDocInfo(R.drawable.out_document, "Stone n CO" , "PA1001","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "TNT","PA1002","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "VTMT","PA1003","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "SUPREME","PA1004","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "BAPE","PA1005","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "EMMANUAL","PA1006","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "NIKE","PA1007","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "ADIDAS","PA1008","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "PUMA","PA1009","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "VANS","PA10010","Des1",currentDateAndTime))
        list.add(OutDocInfo(R.drawable.out_document, "Jordan","PA10011","Des1",currentDateAndTime))
        adapter.notifyDataSetChanged()
    }

}