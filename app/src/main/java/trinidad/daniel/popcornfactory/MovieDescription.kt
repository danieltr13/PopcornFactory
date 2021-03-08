package trinidad.daniel.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_description.*

class MovieDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_description)

        val bundle= intent.extras

        if(bundle!=null){
            iv_img_movie.setImageResource(bundle.getInt("header"))
            tv_movie_title.setText(bundle.getString("title"))
            tv_movie_des.setText(bundle.getString("description"))
        }
    }
}