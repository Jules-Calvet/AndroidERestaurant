package fr.isen.calvet.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.calvet.androiderestaurant.databinding.ActivityDishesBinding
import kotlin.collections.ArrayList

class DishesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDishesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDishesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val title = intent.getStringExtra("Title")
        binding.title.text = title
        //supportActionBar?.title = title

        val dishes = when(title) {
            "Starters" -> resources.getStringArray(R.array.starters)
            "Main Courses" -> resources.getStringArray(R.array.main_courses)
            "Desserts" -> resources.getStringArray(R.array.desserts)
            else -> emptyArray()
        }
        binding.recyclerView.adapter = CategoryAdapter(ArrayList(dishes.asList()))

        binding.buttonReturn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
