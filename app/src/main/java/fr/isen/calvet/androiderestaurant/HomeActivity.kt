package fr.isen.calvet.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val action = findViewById<Button>(R.id.button1)
        action.setOnClickListener{
            Snackbar.make(it, "Entrées", Snackbar.LENGTH_SHORT).show()
        }
    }
}