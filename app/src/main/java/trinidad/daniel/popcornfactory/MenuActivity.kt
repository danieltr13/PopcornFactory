package trinidad.daniel.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_movie_description.view.*
import kotlinx.android.synthetic.main.movie.view.*
import kotlin.random.Random

class MenuActivity : AppCompatActivity() {

    var adapter: MovieAdapter?=null
    var adapterSeries: MovieAdapter?=null
    var movies= ArrayList<Movie>()
    var series= ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        loadMovies()
        adapter= MovieAdapter(this, movies)
        grindView.adapter=adapter

        //loadSeries()
        //adapterSeries= MovieAdapter(this,series)
        //grindViewSeries.adapter=adapterSeries
    }

    fun loadMovies() {
        //Movies
        movies.add(Movie("Big Hero 6", R.drawable.bigherosix, R.drawable.headerbigherosix, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called", arrayListOf<Client>()))
        movies.add(Movie("1917", R.drawable.nineteenseventeen, R.drawable.nineteenseventeenheader, "British trenches somewhere in France. World war has been going on for the third year, heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy.",  arrayListOf<Client>()))
        movies.add(Movie("Leap year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback  when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged.", arrayListOf<Client>()))
        movies.add(Movie("Men in Black", R.drawable.mib, R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency&#39;s finest men only going by the name &quot;K&quot; (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the &quot;Bug&quot; race. He takes the body of a farmer (Vincent D&#39;Onofrio) and heads to New York. He is searching for a super energy source called &quot;The Galaxy&quot;. Now, Agents J and K must stop the bug before it can escape with the galaxy.",arrayListOf<Client>()))
        movies.add(Movie("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the &#39;secret life of toys&#39; when people are not around. When Buzz Lightyear, a space-ranger, takes Woody&#39;s place as Andy&#39;s favorite toy, Woody doesn&#39;t like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home.",arrayListOf<Client>()))
        movies.add(Movie("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb&#39;s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.",arrayListOf<Client>()))
        movies.add(Movie("Fantastic beasts", R.drawable.fantasticbeasts, R.drawable.fantasticbeastsheader, "In 1926, British wizard and \"magizoologist\" Newton \"Newt\" Scamander arrives in New York City. He encounters Mary Lou Barebone, the non-magical (\"No-Maj\" or \"Muggle\") head of the New Salem Philanthropic Society, who preaches that witches and wizards are real and dangerous. Attempting to recapture a Niffler that escaped from his suitcase of magical creatures, Newt meets No-Maj Jacob Kowalski, an aspiring baker, and they unwittingly swap suitcases. ",arrayListOf<Client>()))
        movies.add(Movie("The Aeronauts",R.drawable.aeronauts, R.drawable.aeronautsheader, "In 1862 London, scientist James Glaisher and his pilot Amelia arrive for the launch of the largest balloon ever constructed. Despite being haunted by a vision of her late husband Pierre, Amelia keeps up the brave front and the balloon successfully launches to a cheering crowd. In a flashback, James appears before the Royal Society and explains his theory that the weather can be predicted, but his fellow scientists mock him and refuse to finance his studies. Returning home, he talks to his parents, who try to persuade him to pursue another avenue of science. On the balloon, James and Amelia start rising through the cloud layer.",arrayListOf<Client>()))
        movies.add(Movie("Spiderman into the spiderverse", R.drawable.spiderverse, R.drawable.spiderverseheader, "Miles Morales, a teenager who admires Spider-Man, struggles living up to the expectations of his parents, especially his father, police officer Jefferson Davis, who sees Spider-Man as a menace. After school, Miles secretly visits his uncle Aaron Davis, who brings Miles to an abandoned subway station where he can paint graffiti. While there, Miles is unknowingly bitten by a radioactive spider and, the next day, discovers it gave him spider-like abilities, including the power to turn invisible, and to emit electric venom blasts.",arrayListOf<Client>()))
        movies.add(Movie("Harry Potter",R.drawable.harrypotter, R.drawable.harrypotterheader, "Late one night, Albus Dumbledore and Minerva McGonagall, professors at Hogwarts School of Witchcraft and Wizardry, along with the school's groundskeeper Rubeus Hagrid, deliver a recently orphaned infant named Harry Potter to his only remaining relatives, the Dursleys. Ten years later, Harry has lived a difficult life with the Dursleys. After inadvertently causing an accident during a family trip to London Zoo, Harry begins receiving unsolicited letters by owls. After he and the Dursleys escape to an island to avoid more letters, Hagrid re-appears and informs Harry that he is a wizard and has been accepted into Hogwarts against the Dursleys' wishes. After taking Harry to Diagon Alley to buy his supplies for Hogwarts and a pet owl named Hedwig as a birthday present, Hagrid informs him of his past: Harry's parents James and Lily Potter died due to a Killing Curse at the hands of the malevolent and all-powerful wizard: Lord Voldemort. Harry, the only survivor in the chaos, thus becomes well-known in the wizarding world as The Boy Who Lived",arrayListOf<Client>()))
    }

    /*fun loadSeries(){
        //Series
        series.add(Movie("Bones", R.drawable.bones, R.drawable.bonesheader,"Dr. Temperance Brennan is a brilliant, but lonely, anthropologist whom is approached by an ambitious FBI agent, named Seely Booth, to help the bureau solve a series of unsolved crimes by identifying the long-dead bodies of missing persons by their bone structure. But both Agent Booth and Dr. Brennan and her team come up again a variety of interference from red tape, corruption, and local noncooperation."))
        series.add(Movie("Dr.House", R.drawable.drhouse, R.drawable.drwhoheader, "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try to cure complex and rare diseases from very ill ordinary people in the United States of America."))
        series.add(Movie("Smallville", R.drawable.smallville, R.drawable.smallvilleheader,"The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic egresses in the past. They say he&#39;s either too fast or has a penchant for finding trouble. He was found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted. Clark&#39;s friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for Clark&#39;s outlandish valor. However, on the face of it, Clark just seems a normal boy who&#39;s slightly more secretive than usual."))
        series.add(Movie("Dr.Who", R.drawable.drwho,R.drawable.drwhoheader, "Traveling across time and space, the immortal time-lord known as &#39;The Doctor&#39; travels across the universe with his many companions and his loyal shape-shifting space-ship: The TARDIS. The Doctor faces many threats across many generations: from The Daleks, The Cybermen and his time-lord adversary The Master to the sinister Davros, creator of The Daleks."))
        series.add(Movie("Suits", R.drawable.suits, R.drawable.suitsheader, "While running from a drug deal gone bad, brilliant young college dropout Mike Ross slips into a job interview with one of New York City&#39;s best legal closers, Harvey Specter. Tired of cookie-cutter law-school grads, Harvey takes a gamble by hiring Mike on the spot after recognizing his raw talent and photographic memory. Mike and Harvey are a winning team. Although Mike is a genius, he still has a lot to learn about law; and while Harvey might seem like an emotionless, cold-blooded shark, Mike&#39;s sympathy and concern for their cases and clients will help remind Harvey why he went into law in the first place. Mike&#39;s other allies in the office include the firm&#39;s best paralegal Rachel and Harvey&#39;s no-nonsense assistant Donna. Proving to be an irrepressible duo and invaluable to the\n" + "practice, Mike and Harvey must keep their secret from everyone including managing partner Jessica and Harvey&#39;s archnemesis Louis, who seems intent on making Mike&#39;s life as difficult as possible."))
        series.add(Movie("Friends", R.drawable.friends, R.drawable.friendsheader, "Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay are six 20 something year-olds, living off of one another in the heart of New York City. Over the course of ten years, this average group of buddies goes through massive mayhem, family trouble, past and future romances, fights, laughs, tears and surprises as they learn what it really means to be a friend."))
    }*/
}

class MovieAdapter: BaseAdapter {
    var movies= ArrayList<Movie>()
    var context: Context? = null

    constructor(context: Context, movies:ArrayList<Movie>){
        this.context=context
        this.movies=movies
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var movie= movies[position]
        var inflador=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view= inflador.inflate(R.layout.movie, null)
        view.iv_movie.setImageResource(movie.image)
        view.tv_movie.setText(movie.title)

        view.iv_movie.setOnClickListener {
            var intent = Intent(context, MovieDescription::class.java)
            intent.putExtra("title", movie.title)
            intent.putExtra("image", movie.image)
            intent.putExtra("header", movie.header)
            intent.putExtra("description", movie.description)
            intent.putExtra("numberSeats", (20-movie.seats.size))
            intent.putExtra("pos", position)
            context!!.startActivity(intent)
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return movies[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }


}