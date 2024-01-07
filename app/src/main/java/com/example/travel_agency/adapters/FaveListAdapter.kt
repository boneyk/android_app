package com.example.travel_agency.adapters

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
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.activities.ConfirmActivity
import com.example.travel_agency.activities.TourActivity
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.Tour_Image

class FaveListAdapter (var tours: List<TourFav>, var context: Context): RecyclerView.Adapter<FaveListAdapter.MyViewHolder>() {

    private var sharedPref: SharedPreferences = context.getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPref.edit()
    fun updateData(newTours: List<TourFav>) {
        tours = newTours
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.tour_list_image)
        val country: TextView = view.findViewById(R.id.tour_list_country)
        val city: TextView = view.findViewById(R.id.tour_list_city)
        val price: TextView = view.findViewById(R.id.tour_list_price)
        val tour_type: TextView = view.findViewById(R.id.tour_list_tour_type)
        val btn: Button = view.findViewById(R.id.tour_list_button)
        val del_btn: Button = view.findViewById(R.id.del_button_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_in_fave, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tours.size
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

        holder.btn.setOnClickListener{
            val tour_id = currentTour.id
            val intent = Intent(context, TourActivity::class.java)
            intent.putExtra("tour_id", tour_id)
            context.startActivity(intent)
        }

        holder.del_btn.setOnClickListener{
            val tour_id = currentTour.id
            editor.putInt("tour_id", tour_id).apply()

            val intent = Intent(context, ConfirmActivity::class.java)
            context.startActivity(intent)
        }
    }
}
