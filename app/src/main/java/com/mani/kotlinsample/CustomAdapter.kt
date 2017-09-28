package com.mani.kotlinsample

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Mani on 22-09-2017.
 */

class CustomAdapter(val arr: ArrayList<Main2Activity.User>,val context:Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)

        return ViewHolder(v)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        //holder.bindItems(arr[position])
        holder.tvName.text = arr.get(position).name
        holder.tvAddre.text = arr.get(position).address

        /*On item click listener*/
        holder.itemView.setOnClickListener {
            Log.w("click", arr.get(position).address)
            val activityIntent=Intent(context,WebviewActivity::class.java)
            activityIntent.putExtra("values",arr.get(position).name)
            context.startActivity(activityIntent)
        }
    }

    override fun getItemCount(): Int {
        return arr.size;

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.findViewById<TextView>(R.id.tvName) as TextView
        val tvAddre = itemView.findViewById<TextView>(R.id.tvAddr) as TextView

    }
    interface OnItemClickListener {
        fun onItemClick(view: View, pos: Int)
        fun onLongItemClick(view: View, pos: Int)
    }
}