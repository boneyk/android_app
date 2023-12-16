package com.example.travel_agency.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.activities.TourActivity
import com.example.travel_agency.models.Tours

class FaveListAdapter (var tours: List<Tours>, var context: Context): RecyclerView.Adapter<FaveListAdapter.MyViewHolder>() {
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.tour_list_image)
        val country: TextView = view.findViewById(R.id.tour_list_country)
        val date_start: TextView = view.findViewById(R.id.tour_list_datestart)
        val date_end: TextView = view.findViewById(R.id.tour_list_dateend)
        val price: TextView = view.findViewById(R.id.tour_list_price)
        val btn: Button = view.findViewById(R.id.tour_list_button)
        val btn_del: Button = view.findViewById(R.id.del_button_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_in_fave,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tours.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.country.text = tours[position].country
//        holder.date_start.text = tours[position].date_start
        holder.price.text = tours[position].name
//        holder.date_end.text = tours[position].date_end

//        val imageId = context.resources.getIdentifier(
//            tours[position].image,
//            "drawable",
//            context.packageName
//        )
//        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener{
            val intent = Intent(context, TourActivity::class.java)
//            intent.putExtra("tourTitle",tours[position].country)
//            intent.putExtra("tourCity",tours[position].city)
//            intent.putExtra("tourSDate",tours[position].date_start)
//            intent.putExtra("tourEDate",tours[position].date_end)
//            intent.putExtra("tourDesc",tours[position].description)
            intent.putExtra("tourPrice",tours[position].name)
            context.startActivity(intent)
        }
        holder.btn_del.setOnClickListener{
            notifyItemRemoved(position) // Уведомляем адаптер об удалении элемента
        }
    }
}