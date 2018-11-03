package com.example.dev.pola.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.dev.pola.model.Placemark
import java.util.ArrayList
import android.view.LayoutInflater
import android.widget.TextView
import com.example.dev.pola.R
import com.example.dev.pola.activity.CarDetailActivity
import com.example.dev.pola.utils.AppConstants
import kotlinx.android.synthetic.main.item_view_placemarker.view.*


class PlaceMArkerAdapter() :
    RecyclerView.Adapter<PlaceMArkerAdapter.ViewHolderPlaceMarker>() {
    var placemarks: ArrayList<Placemark>? = null

    init {
        placemarks=ArrayList<Placemark>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolderPlaceMarker {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_placemarker, parent, false)
        return ViewHolderPlaceMarker(itemView)
    }

    fun setPlaceMarksList(placemarklist: ArrayList<Placemark>) {
        this.placemarks = placemarklist
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return placemarks!!.size
    }

    override fun onBindViewHolder(viewHolderPlaceMarker: ViewHolderPlaceMarker, position: Int) {
        viewHolderPlaceMarker.name.text = placemarks?.get(position)?.name
        viewHolderPlaceMarker.engineType.text = placemarks?.get(position)?.engineType
        viewHolderPlaceMarker.vin.text = placemarks?.get(position)?.vin
        viewHolderPlaceMarker.tvAddress.text = placemarks?.get(position)?.address
        viewHolderPlaceMarker.itemView.setOnClickListener {
            val intent =
                Intent(viewHolderPlaceMarker.itemView.context, CarDetailActivity::class.java)
            intent.putParcelableArrayListExtra(AppConstants.PLACEMARKER_LIST,placemarks)
            intent.putExtra(AppConstants.currenPosition,position)
            viewHolderPlaceMarker.itemView.context.startActivity(intent)
        }
    }

    class ViewHolderPlaceMarker(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.tvName
        val engineType: TextView = itemView.tvEngineType
        val vin: TextView = itemView.tvVin
        val tvAddress: TextView = itemView.tvAddress
    }
}