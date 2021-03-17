package trinidad.daniel.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_description.*
import kotlinx.android.synthetic.main.activity_reservation.*

class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val bundle= intent.extras
        var seat = -1
        if(bundle!=null) {
            title = bundle.getString("title")!!
            titleTv.setText("Movie: $title ")
            seat = bundle.getInt("seat")
            seatTv.setText("Seat: $seat")
        }
    }
}