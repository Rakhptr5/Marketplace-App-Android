package com.example.marketplace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridProductAdapter (val listProduk: ArrayList<product>): RecyclerView.Adapter<GridProductAdapter.GridViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int):GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cardviewproduct, viewGroup, false)
        return GridViewHolder(view)
    }
    override fun onBindViewHolder(holder: GridProductAdapter.GridViewHolder, position: Int) {
        val (name, description, price, foto) = listProduk[position]

        Glide.with(holder.itemView.context)
            .load(foto)
            .apply(RequestOptions().override(2000,2000))
            .into(holder.imgphoto)
        holder.tvName.text = name
        holder.tvDesc.text = description
        holder.tvPrice.text = price
        holder.itemView.setOnClickListener {onItemClickCallback.onItemClicked(listProduk[holder.adapterPosition])}


    }
    override fun getItemCount(): Int {
        return listProduk.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDesc: TextView = itemView.findViewById(R.id.tv_description)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_harga)
        var imgphoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
    interface OnItemClickCallback{
        fun onItemClicked(data : product)
    }
}