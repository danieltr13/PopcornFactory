package trinidad.daniel.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_description.*
import java.util.Random

class MovieDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_description)

        val bundle= intent.extras
        var ns = 0
        var id = -1
        var title = ""

        if(bundle!=null) {
            ns = bundle.getInt("numberSeats")

            iv_img_movie.setImageResource(bundle.getInt("header"))
            title = bundle.getString("title")!!
            tv_movie_title.setText(title)
            tv_movie_des.setText(bundle.getString("description"))
            seatsLeft.setText("$ns  seats available")
            id=bundle.getInt("pos")
        }

        if(ns==0){
            buyTickets.isEnabled = false
        }else {
            val random = Random()
            val seats= random.nextInt(21)
            seatsLeft.setText("$seats  seats available")
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("title", title)
                intent.putExtra("seats", seats)
                this.startActivity(intent)
            }
        }
    }

}