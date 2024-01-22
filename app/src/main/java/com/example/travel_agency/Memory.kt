import android.content.Context
import android.util.Log
import com.example.travel_agency.models.ConfRequest
import com.example.travel_agency.models.LoginResponse
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.Person

class Memory(context: Context) {
    companion object {
        var conf_info: ConfRequest = ConfRequest(1, 1, "1", listOf(Person("1", "1")))
        var persons: List<Person> = listOf(Person("1","1"))
        var tour_id: Int = 1
        var status: String = "1"
        var date_id: Int = 1
    }

    fun saveStatus(info : String){
        status = info
    }
    fun getStatus() : String{
        return status
    }
    fun saveTourId(info : Int){
        tour_id = info
    }
    fun getTourId() : Int{
        return tour_id
    }

    fun saveDate(info : Int){
        date_id = info
    }
    fun getDate() : Int{
        return date_id
    }
    fun saveConf(info : ConfRequest){
        conf_info = info
    }
    fun getConf() : ConfRequest{
        return conf_info
    }
    fun savePers(info : List<Person>){
        persons = info
    }
    fun getPers() : List<Person>{
        return persons
    }
}