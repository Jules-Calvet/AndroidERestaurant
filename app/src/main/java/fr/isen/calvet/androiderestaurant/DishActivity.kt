package fr.isen.calvet.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.calvet.androiderestaurant.databinding.ActivityDishBinding

class DishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dishName = intent.getStringExtra("Dish Name")
        binding.dishName.text = dishName

        binding.buttonReturn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }



}