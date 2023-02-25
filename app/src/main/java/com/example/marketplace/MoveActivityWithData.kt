package com.example.marketplace

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoveActivityWithData : AppCompatActivity(), View.OnClickListener {

    lateinit var btnGrid: ImageButton
    lateinit var btnList: ImageButton
    lateinit var rvProducts: RecyclerView
    var list: ArrayList<product> = arrayListOf()
    private lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)
        supportActionBar?.hide()

        rvProducts = findViewById(R.id.rv_product)
        rvProducts.setHasFixedSize(true)
        btnGrid = findViewById(R.id.btn_grid)
        btnList = findViewById(R.id.btn_list)

        btnGrid.setOnClickListener(this)
        btnList.setOnClickListener(this)

        list.addAll(ProductList.listData)
        showRecyclerGrid()
    }
    private fun showRecyclerList(){
        rvProducts.layoutManager = LinearLayoutManager(this)
        val listProductAdapter = ListProductAdapter(list)
        rvProducts.adapter =listProductAdapter

        listProductAdapter.setOnItemClickCallback(object : ListProductAdapter.OnItemClickCallback{
            override fun onItemClicked(data: product) {
                showSelectedHero(data)
            }
        })
    }
    private fun showRecyclerGrid(){
        rvProducts.layoutManager = GridLayoutManager(this,2)
        val gridProdukAdapter = GridProductAdapter(list)
        rvProducts.adapter =gridProdukAdapter

        gridProdukAdapter.setOnItemClickCallback(object : GridProductAdapter.OnItemClickCallback{
            override fun onItemClicked(data: product) {
                showSelectedHero(data)
            }
        })
    }
    private fun showSelectedHero(produk: product){
        Toast.makeText(this,"Berhasil menambahkan " + produk.name, Toast.LENGTH_SHORT).show()
    }
    override fun onClick(v: View){
        when (v.id) {
            R.id.btn_list -> {
                showRecyclerList()
            }
            R.id.btn_grid -> {
                showRecyclerGrid()
            }
        }
    }
}
