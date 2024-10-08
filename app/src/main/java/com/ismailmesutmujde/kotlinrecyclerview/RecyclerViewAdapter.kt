package com.ismailmesutmujde.kotlinrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val mContext : Context, private val countriesList : List<Countries>) : RecyclerView.Adapter<RecyclerViewAdapter.CardViewDesignObjectsHolder>() {

    inner class CardViewDesignObjectsHolder(view : View) : RecyclerView.ViewHolder(view) {
        var rowCardView : CardView
        var rowText : TextView
        var dotImage : ImageView

        init {
            rowCardView = view.findViewById(R.id.rowCardView)
            rowText = view.findViewById(R.id.rowText)
            dotImage = view.findViewById(R.id.dotImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjectsHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)
        return CardViewDesignObjectsHolder(design)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    override fun onBindViewHolder(holder: CardViewDesignObjectsHolder, position: Int) {
        val country = countriesList[position]
        holder.rowText.text = country.countryName
        holder.rowCardView.setOnClickListener {
            Toast.makeText(mContext, "Chosen Country : ${country.countryName}", Toast.LENGTH_SHORT).show()
        }

        holder.dotImage.setOnClickListener {
            val popup = PopupMenu(mContext, holder.dotImage)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_delete -> {
                        Toast.makeText(mContext, "Delete : ${country.countryName}", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_edit -> {
                        Toast.makeText(mContext, "Edit : ${country.countryName}", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }

            }
        }
    }


}