package com.example.travel_agency.activities


import Memory
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.MultiAutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.BasketViewModel
import com.example.travel_agency.ViewModel.FaveViewModel
import com.example.travel_agency.ViewModel.TourWithIdViewModel
import com.example.travel_agency.databinding.ActivityTourBinding
import com.example.travel_agency.models.ConfRequest
import com.example.travel_agency.models.Dates
import com.example.travel_agency.models.Person

class TourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTourBinding
    private lateinit var viewModel: TourWithIdViewModel
    private lateinit var tourIdModel: TourWithIdViewModel
    private lateinit var faveViewModel: FaveViewModel
    private lateinit var basketViewModel: BasketViewModel

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MyLog", "создал sharedPref и editor")
        viewModel = ViewModelProvider(this).get(TourWithIdViewModel::class.java)
        sharedPref = getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPref.edit()



        val curImage: ImageView = binding.tourListImage
        val country: TextView = binding.tourCountry
        val city: TextView = binding.tourCity
        val capacity: TextView = binding.tourCapacity
//        val sDate: TextView = binding.tourListDateS
//        val fDate: TextView = binding.tourListDateF
        val desc: TextView = binding.tourListDesc
        val price: TextView = binding.tourPrice

        val selectedPeople = mutableListOf<Person>()
        var selectedDate: Dates? = null
        val tourId = intent.getIntExtra("tour_id", 0)
        val userId = sharedPref.getString("token", null)!!
        Log.d("MyLog", "tour_id = $tourId")
        tourIdModel = ViewModelProvider(this).get(TourWithIdViewModel::class.java)
        tourIdModel.findTourWithId(tourId,userId)
        tourIdModel.tourWithId.observe(this, Observer { tour ->
            country.text = tour?.tour?.name
            city.text = "Город: " + tour?.tour?.city
            capacity.text = tour?.tour?.tour_type
//            sDate.text = "Начало: " + tour?.tour?.date?.getOrNull(0)?.dateStart
//            fDate.text = "Конец: " + tour?.tour?.date?.getOrNull(0)?.dateEnd
            desc.text = tour?.tour?.description
            price.text = tour?.tour?.price_per_one.toString() + " руб."
            // Установка изображения в соответствии с элементом массива tour.images
            val imageId = resources.getIdentifier(tour?.tour?.images?.get(0)?.filename, "drawable", packageName)
            curImage.setImageResource(imageId)

            val tourists: List<String> = tour.persons.map { it.fullname }
            val listView: ListView = findViewById(R.id.listView)
            val textView: TextView = findViewById(R.id.noticeView)
            textView.visibility = View.GONE


            if (tourists.isNotEmpty()) {
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, tourists)
                listView.adapter = adapter
                listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
            } else {
                listView.visibility = View.GONE
                textView.text = "Пока нет доступных туристов, перейдите в раздел Туристы и Документы в личном кабинете"
                textView.visibility = View.VISIBLE
            }


            listView.setOnItemClickListener { parent, view, position, id ->
                val selectedPersonName = parent.getItemAtPosition(position) as String
                val selectedPerson = tour.persons.find { it.fullname == selectedPersonName }
                if (selectedPerson != null) {
                    if (!selectedPeople.contains(selectedPerson)) {
                        selectedPeople.add(selectedPerson)
                    } else {
                        selectedPeople.remove(selectedPerson)
                    }
                }
            }

            val dates: List<String> = tour?.tour?.date?.map { "с ${it.dateStart} по ${it.dateEnd}" } ?: emptyList()

            val dateSpinner: Spinner = findViewById(R.id.datesSpinner)

            val dateAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dates)
            dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            dateSpinner.adapter = dateAdapter

            dateSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedDate = tour?.tour?.date?.get(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Обработка ситуации, когда ничего не выбрано
                    selectedDate = null
                }
            }


        })

        val linkToConfirm: TextView = findViewById(R.id.button_buy)
        val linkToFave: TextView = findViewById(R.id.button_toFave)
        val linkFromFave: TextView = findViewById(R.id.button_fromFave)
        linkToConfirm.setOnClickListener {
            if(selectedPeople.size != 0 && selectedDate != null ) {
                Log.d(
                    "MyLog",
                    "в selectedPeople - ${selectedPeople[0].fullname}, ${selectedDate?.dateStart}"
                )
                editor.putInt("tour_id", tourId).apply()
                editor.putInt("date_id", selectedDate!!.id).apply()
                val tour_id = sharedPref.getInt("tour_id", 0)
                val user_id = sharedPref.getString("token", null)!!
                val date_id = sharedPref.getInt("date_id", 0)
                Memory(this).saveConf(ConfRequest(date_id, tour_id, user_id, selectedPeople))
                Toast.makeText(this, "Давайте подтвердим заказ!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, ConfirmActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Выберите туристов и дату!", Toast.LENGTH_LONG).show()
            }
        }
        linkToFave.setOnClickListener {
            val tour_id = sharedPref.getInt("tour_id", 0)
            val user_id = sharedPref.getString("token", null)
            faveViewModel = ViewModelProvider(this)[FaveViewModel::class.java]
            faveViewModel.updateFave(tour_id,user_id!!)
        }
        linkFromFave.setOnClickListener {
            val tour_id = sharedPref.getInt("tour_id", 0)
            val user_id = sharedPref.getString("token", null)
            faveViewModel = ViewModelProvider(this)[FaveViewModel::class.java]
            faveViewModel.deleteFave(tour_id,user_id!!)
            faveViewModel.findFavetour(user_id)
        }
    }
}
