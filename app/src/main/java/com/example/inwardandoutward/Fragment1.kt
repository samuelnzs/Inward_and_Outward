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
import com.example.inwardandoutward.recycler_view_adapter.IncomingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*


class Fragment1 : Fragment() {

    lateinit var recycle : RecyclerView
    private  val  list = ArrayList<InDocInfo>()
    private val adapter: IncomingAdapter = IncomingAdapter(list)
    private val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd  HH:mm:ss")
    private val currentDateAndTime: String = simpleDateFormat.format(Date())

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1_layout, container, false)
    }

   override fun onViewCreated(view: View,savedInstanceState: Bundle?){
       super.onViewCreated(view, savedInstanceState)

       //Link RecyclerView

       recycle = view. findViewById(R.id.rcyIncomingDoc)
       val adapter = IncomingAdapter(list)
       recycle.layoutManager = LinearLayoutManager(activity)
       recycle.adapter = adapter

       val addButton: FloatingActionButton = view.findViewById<FloatingActionButton>(R.id.addInDoc)

       addButton.setOnClickListener{
           val dialogView : View = LayoutInflater.from(context).inflate(R.layout.add_indoc,null)
           val builder : AlertDialog.Builder? =
               context?.let { it1 -> AlertDialog.Builder(it1).setView(dialogView).setTitle("Add Incoming Document") }
           val alert : AlertDialog = builder!!.show()

           val addButton: Button =  dialogView.findViewById(R.id.btnInAdd)
           addButton.setOnClickListener{
               alert.dismiss()
              val supName = dialogView.findViewById<EditText>(R.id.supplierName)
               val desc = dialogView.findViewById<EditText>(R.id.InDescription)

               list.add(InDocInfo(R.drawable.receipt_image, supName.text.toString(), list[list.size-1].InId+1, desc.text.toString(),currentDateAndTime))


           }
       }

       val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){

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
        list.add(InDocInfo(R.drawable.receipt_image, "Stone n CO" , "PA1001","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "TNT","PA1002","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "VTMT","PA1003","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "SUPREME","PA1004","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "BAPE","PA1005","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "EMMANUAL","PA1006","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "NIKE","PA1007","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "ADIDAS","PA1008","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "PUMA","PA1009","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "VANS","PA10010","Des1", currentDateAndTime))
        list.add(InDocInfo(R.drawable.receipt_image, "Jordan","PA10011","Des1", currentDateAndTime))
        adapter.notifyDataSetChanged()
    }

}