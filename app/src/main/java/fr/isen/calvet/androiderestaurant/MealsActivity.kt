package fr.isen.calvet.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.calvet.androiderestaurant.databinding.ActivityMealsBinding
import java.util.*
import kotlin.collections.ArrayList

class MealsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMealsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val title = intent.getStringExtra("Title")
        binding.title.text = title
        //supportActionBar?.title = title

       /* val category = DishCategory.valueOf(title)
        val dishes = resources.getStringArray(category.arrayResourceId)
        binding.recyclerView.adapter = CategoryAdapter(ArrayList(dishes.asList()))*/


        val dishes = when(title) {
            "Starters" -> resources.getStringArray(R.array.starters)
            "Main Courses" -> resources.getStringArray(R.array.main_courses)
            "Desserts" -> resources.getStringArray(R.array.desserts)
            else -> emptyArray()
        }
        binding.recyclerView.adapter = CategoryAdapter(ArrayList(dishes.asList()))


      //  binding.recyclerView.adapter = CategoryAdapter(resources.getStringArray(R.array.starters).toList() as ArrayList<String>)

        binding.buttonReturn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
