package fr.isen.calvet.androiderestaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import fr.isen.calvet.androiderestaurant.databinding.ActivityDishBinding
import java.io.File

class DishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dishCategory = intent.getStringExtra("Category")
        val dishName = intent.getStringExtra("Name") as String
        val dishPrice = intent.getFloatExtra("Price", 0f)
        val dishImage = intent.getStringArrayListExtra("Image") as ArrayList<String>
        val dishIngredients = intent.getStringArrayListExtra("Ingredients")
        binding.dishName.text = dishName
        binding.viewPager2.adapter = ViewPagerAdapter(dishImage)
        if(dishPrice.compareTo(dishPrice.toInt()) == 0)
            binding.dishPrice.text = "Total : ${dishPrice.toInt()}€"
        else
            binding.dishPrice.text = "Total : $dishPrice€"
        var ingredientsList = ""
        if (dishIngredients != null) {
            for(ingredients in dishIngredients) {
                if(ingredientsList.isEmpty())
                    ingredientsList = ingredients
                else
                    ingredientsList = "$ingredientsList, $ingredients"
            }
        }
        binding.dishIngredients.text = ingredientsList

        binding.buttonReturn.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("Title", dishCategory)
            startActivity(intent)
        }

        var quantity = 1
        binding.quantity.text = "$quantity"

        binding.buttonMoins.setOnClickListener {
            if(quantity > 0)
                quantity--
            binding.quantity.text = "$quantity"
            val price = quantity * dishPrice
            if(price.compareTo(price.toInt()) == 0)
                binding.dishPrice.text = "Total : ${price.toInt()}€"
            else
                binding.dishPrice.text = "Total : $price€"
        }

        binding.buttonPlus.setOnClickListener {
            quantity++
            binding.quantity.text = "$quantity"
            val price = quantity * dishPrice
            if(price.compareTo(price.toInt()) == 0)
                binding.dishPrice.text = "Total : ${price.toInt()}€"
            else
                binding.dishPrice.text = "Total : $price€"
        }

        binding.dishPrice.setOnClickListener {
            if (quantity != 0) {
                val panier = Panier(dishName, quantity, quantity * dishPrice, dishImage[0])
                val gson = GsonBuilder().create()
                val json = gson.toJson(panier)
                val fileOutputStream = openFileOutput("panier.json", Context.MODE_PRIVATE)
                fileOutputStream.write(json.toByteArray())
                fileOutputStream.close()
                Snackbar.make(it, "$quantity $dishName added to cart", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    data class Panier (
        val name : String,
        val quantity : Int,
        val price : Float,
        val image: String
    )
}