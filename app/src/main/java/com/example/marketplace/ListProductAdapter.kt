package com.example.marketplace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListProductAdapter (val listProduk: ArrayList<product>): RecyclerView.Adapter<ListProductAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ListViewHolder{
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.listviewproduct, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, price, foto) = listProduk[position]

        Glide.with(holder.itemView.context)
            .load(foto)
            .apply(RequestOptions().override(2000,2000))
            .into(holder.imgphoto)
        holder.tvName.text = name
        holder.tvDesc.text = description
        holder.tvPrice.text = price
        holder.itemView.setOnClickListener {onItemClickCallback.onItemClicked(listProduk[holder.adapterPosition])}

        holder.btnFavorite.setOnClickListener { Toast.makeText(holder.itemView.context, "Berhasil Menambahkan " + listProduk[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var imgphoto: ImageView = itemView.findViewById(R.id.img_list)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_fav)
    }
    interface OnItemClickCallback{
        fun onItemClicked(data : product)
    }

}