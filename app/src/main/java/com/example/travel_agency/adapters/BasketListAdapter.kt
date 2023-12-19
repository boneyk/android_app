package com.example.travel_agency.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.Tour_Image
import com.example.travel_agency.models.Tours

class BasketListAdapter(var tours: List<TourFav>, var context: Context): RecyclerView.Adapter<BasketListAdapter.MyViewHolder>() {
    fun updateData(newTours: List<TourFav>) {
        tours = newTours
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.tour_list_image)
        val country: TextView = view.findViewById(R.id.tour_list_country)
        val city: TextView = view.findViewById(R.id.tour_list_city)
        val price: TextView = view.findViewById(R.id.tour_list_price)
        val tour_type: TextView = view.findViewById(R.id.tour_list_tour_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_in_basket,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tours.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTour = tours[position]
        holder.country.text = currentTour.country
        holder.city.text = currentTour.city
        holder.tour_type.text = currentTour.tour_type
        holder.price.text = currentTour.price_per_one.toString()

        val currentImage:List<Tour_Image> = tours[position].images
        if(currentImage.isNullOrEmpty()) {
            Log.d("MyLog", "список пустой")
        } else {
            Log.d("MyLog", "массив не пуст")
            val imageId = context.resources.getIdentifier(
                currentImage[0].filename,
                "drawable",
                context.packageName
            )
            holder.image.setImageResource(imageId)
        }
    }
}