package com.example.travel_agency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TourAdapter(var tours: List<Tour>,var context: Context): RecyclerView.Adapter<TourAdapter.MyViewHolder>() {
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.tour_list_image)
        val country: TextView = view.findViewById(R.id.tour_list_country)
        val date_start: TextView = view.findViewById(R.id.tour_list_datestart)
        val price: TextView = view.findViewById(R.id.tour_list_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_in_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tours.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.country.text = tours[position].country
        holder.date_start.text = tours[position].date_start
        holder.price.text = tours[position].price_per_one.toString()

        val imageId = context.resources.getIdentifier(
            tours[position].image,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)

    }
}