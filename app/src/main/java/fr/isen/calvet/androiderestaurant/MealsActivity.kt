package fr.isen.calvet.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.calvet.androiderestaurant.databinding.ActivityMealsBinding

class MealsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMealsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("Title")
        binding.title.text = title

        binding.buttonReturn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}