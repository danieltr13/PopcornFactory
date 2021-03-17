package trinidad.daniel.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*
import kotlin.collections.ArrayList

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)
        val titleTv: TextView = findViewById(R.id.titleSeats)
        val bundle = intent.extras
        var title = ""
        var posMovie = -1
        var seats = -1

        if (bundle != null) {
            title= bundle.getString("title").toString()
            titleTv.setText(title)
            posMovie = bundle.getInt("id")
            //igualar seats lo que reciba
            seats = bundle.getInt("seats")
        }

        val confirm: Button = findViewById(R.id.confirm)

        confirm.setOnClickListener {

            var seat_selected = seatselection()
            val intent: Intent = Intent (this, ReservationActivity::class.java)
            intent.putExtra("seat", seat_selected)
            intent.putExtra("title", title)
            startActivity(intent)
            finish()
            //Toast.makeText(this, "Enjor the movie! :D", Toast.LENGTH_LONG).show()
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row1.check(checkedId)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId >-1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId >-1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                row4.check(checkedId)
            }
        }
        disableButtons(seats)
    }

    fun disableButtons(seatsav: Int){
        var asientos: ArrayList<Int> = ArrayList<Int>()

        for (i in 0 until seatsav){
            asientos.add(1)
        }

        for (i in seatsav until 20){
            asientos.add(0)
        }

        Collections.shuffle(asientos)

        for(i in 0 until 20){
            if(asientos.get(i) ==  0){
                var radioid: String = "seat"+(i+1)
                var resID: Int = resources.getIdentifier(radioid, "id", packageName)
                var radio: RadioButton = findViewById(resID)
                radio.isEnabled = false
            }
        }
    }

    fun seatselection(): Int{
        var seat = 0
        for(i in 0 until 20){
            var radioid: String = "seat"+(i+1)
            var resID: Int = resources.getIdentifier(radioid, "id", packageName)
            var radio: RadioButton = findViewById(resID)
            if(radio.isChecked){
                seat =i+1
            }
        }
        return seat
    }
}