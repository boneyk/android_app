package com.example.travel_agency

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ToursActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_tours)
        val toursList: RecyclerView = findViewById(R.id.toursList)
        val tours = arrayListOf<Tour>()

        tours.add(Tour(1,"Египет", "Каир", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse elit velit, venenatis tempus egestas in, iaculis sed mi. Praesent ultrices blandit elit id pellentesque. Nulla nec odio at eros vehicula eleifend. Etiam posuere bibendum ante eget facilisis. Quisque sed sollicitudin eros, non rhoncus nisi. Vestibulum posuere dui sit amet justo mollis, vel finibus mauris blandit. Aliquam tincidunt nunc ac erat mattis posuere. Proin pharetra ante eget urna rutrum molestie. Maecenas ante tellus, sodales ac molestie ac, vehicula eget ligula.","19-11-2023", "26-11-2023",3,"3500 руб.","egypt_title"))
        tours.add(Tour(2,"Нидерланды", "Амстердам", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse elit velit, venenatis tempus egestas in, iaculis sed mi. Praesent ultrices blandit elit id pellentesque. Nulla nec odio at eros vehicula eleifend. Etiam posuere bibendum ante eget facilisis. Quisque sed sollicitudin eros, non rhoncus nisi. Vestibulum posuere dui sit amet justo mollis, vel finibus mauris blandit. Aliquam tincidunt nunc ac erat mattis posuere. Proin pharetra ante eget urna rutrum molestie. Maecenas ante tellus, sodales ac molestie ac, vehicula eget ligula.","21-11-2023", "24-11-2023",2,"5500 руб.","amsterdam"))
        tours.add(Tour(3,"Южная Корея", "Сеул", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse elit velit, venenatis tempus egestas in, iaculis sed mi. Praesent ultrices blandit elit id pellentesque. Nulla nec odio at eros vehicula eleifend. Etiam posuere bibendum ante eget facilisis. Quisque sed sollicitudin eros, non rhoncus nisi. Vestibulum posuere dui sit amet justo mollis, vel finibus mauris blandit. Aliquam tincidunt nunc ac erat mattis posuere. Proin pharetra ante eget urna rutrum molestie. Maecenas ante tellus, sodales ac molestie ac, vehicula eget ligula.","30-11-2023", "06-12-2023",1,"2500 руб.","southkorea"))
        tours.add(Tour(4,"Тайланд", "Бангкок", "    7 дней\n" + "\n" + "  Прибытие в страну\n" + "  Прилетим в столицу Таиланда - Бангкок. Отдохнем в отеле, а вечером устроим вечер знакомств.\n" + "\n" + "  Ват Ронг Кхун\n" + "  Белый храм в Таиланде, впечатляющий своей красотой и мистической атмосферой.\n" + "\n" + "  Провинция Чиангмай \n" + " Прогуляемся по прекрасное место, где сочетаются величественные горы, древние храмы и богатое культурное наследие, привлекающее туристов со всего мира.","01-12-2023", "08-12-2023",3,"150 154 руб.","thailand"))
        tours.add(Tour(5,"Мальдивы", "Острова Велиганду", "    4 дня\n" + "\n" + "  Прибытие в страну\n" + "  Прилетим на Мальдивские острова. Отдохнем в отеле, после пойдем купаться.\n" + "\n" + "  Банановый риф\n" + "  Риф имеет форму банана, поражает своими фантастическими кораллами, удивительными скалами, выступами и пещерами.\n" + "\n" + "  Пляж острова Велиганду\n" + " Пляж острова находится в непосредственной близости от рыбацкой деревни, а потому вкусная еда на острове гарантирована.","01-12-2023", "05-12-2023",2,"255 367 руб.","maldives"))

        toursList.layoutManager = LinearLayoutManager(this)
        toursList.adapter = TourAdapter(tours,this)
    }
}