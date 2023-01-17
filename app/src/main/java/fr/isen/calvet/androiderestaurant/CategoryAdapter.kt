package fr.isen.calvet.androiderestaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(var dishes: ArrayList<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellName: Button = view.findViewById<Button>(R.id.dish)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dish, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dish = dishes[position]

        holder.cellName.text = dish

        holder.cellName.setOnClickListener {
            val intent = Intent(it.context, DishActivity::class.java)
            intent.putExtra("Dish Name", dish)
            startActivity(it.context, intent, null)
        }
    }

    override fun getItemCount(): Int = dishes.size

}
