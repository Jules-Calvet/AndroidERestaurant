package fr.isen.calvet.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CategoryAdapter(var dishes: /*ArrayList<String>*/ List<CategoryActivity.Item>, val onItemClickListener: (CategoryActivity.Item) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishName: TextView = view.findViewById(R.id.dishName)
        val dishPrice : TextView = view.findViewById(R.id.dishPrice)
        val dishImage : ImageView = view.findViewById(R.id.dishImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dish, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dish = dishes[position]
        holder.dishName.text = dish.name_fr
        if(dish.prices[0].price.compareTo(dish.prices[0].price.toInt()) == 0)
            holder.dishPrice.text = "${dish.prices[0].price.toInt()}€"
        else
            holder.dishPrice.text = "${dish.prices[0].price}€"
        if(dish.name_fr == "Burger maison") Picasso.get().load(dish.images[1]).into(holder.dishImage)
        else if(dish.images[0] != "") Picasso.get().load(dish.images[0]).into(holder.dishImage)

        holder.itemView.setOnClickListener {
            onItemClickListener(dish)
        }
    }

    override fun getItemCount(): Int = dishes.size

}