package com.example.travel_agency.adapters

import Memory
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.activities.SeeConfActivity
import com.example.travel_agency.activities.TourActivity
import com.example.travel_agency.models.HistElement
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.Tour_Image

class BasketListAdapter(var tours: List<HistElement>, var context: Context): RecyclerView.Adapter<BasketListAdapter.MyViewHolder>() {
    fun updateData(newTours: List<HistElement>) {
        tours = newTours
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.tour_list_image)
        val country: TextView = view.findViewById(R.id.tour_list_country)
        val city: TextView = view.findViewById(R.id.tour_list_city)
        val price: TextView = view.findViewById(R.id.tour_list_price)
        val tour_type: TextView = view.findViewById(R.id.tour_list_tour_type)
        val btn: Button = view.findViewById(R.id.basket_list_button)
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
        holder.country.text = currentTour.status
        holder.city.text = currentTour.bookingEntity.tour.city
        holder.tour_type.text = currentTour.bookingEntity.tour.country
        val pricePerOne = (currentTour.people_amount * currentTour.bookingEntity.tour.price_per_one)
        val formattedPrice = String.format("%,d", pricePerOne).replace(",", " ")
        holder.price.text = "$formattedPrice руб."

        val currentImage:List<Tour_Image> = tours[position].bookingEntity.tour.images
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
        holder.btn.setOnClickListener{
            val tour_id = currentTour.bookingEntity.tour.id
            Log.d("MyLog", "tour_id = $tour_id")
            val intent = Intent(context, SeeConfActivity::class.java)
            intent.putExtra("tour_id", tour_id)
            Memory(context).saveStatus(currentTour.status)
            intent.putExtra("date_id", currentTour.bookingEntity.date.id)
            Memory(context).savePers(currentTour.participants)
            context.startActivity(intent)
        }
    }
}