import android.content.Context
import android.util.Log
import com.example.travel_agency.models.ConfRequest
import com.example.travel_agency.models.LoginResponse
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.Person

class Memory(context: Context) {
    companion object {
        var conf_info: ConfRequest = ConfRequest(1, 1, "1", listOf(Person("1", "1")))
    }

    fun saveConf(info : ConfRequest){
        conf_info = info
    }
    fun getConf() : ConfRequest{
        return conf_info
    }
}