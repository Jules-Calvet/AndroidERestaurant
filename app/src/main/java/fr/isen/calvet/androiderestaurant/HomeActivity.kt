package fr.isen.calvet.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import fr.isen.calvet.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("Title", getString(R.string.first))
            startActivity(intent)
            finish()
            //Snackbar.make(it, "Entrées", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText( this,"Entrées", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("Title", getString(R.string.second))
            startActivity(intent)
            finish()
            //Snackbar.make(it, "Plats", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText( this,"Plats", Toast.LENGTH_SHORT).show()
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("Title", getString(R.string.third))
            startActivity(intent)
            finish()
            //Snackbar.make(it, "Désserts", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText( this,"Désserts", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "Activity Destroyed")
    }
}