package com.ismailmesutmujde.kotlinrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismailmesutmujde.kotlinrecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityMainBinding

    private lateinit var countriesList : ArrayList<Countries>
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        bindingMain.recyclerView.setHasFixedSize(true)
        bindingMain.recyclerView.layoutManager = LinearLayoutManager(this)

        val c1 = Countries(1,"Türkiye")
        val c2 = Countries(2,"Italy")
        val c3 = Countries(3,"Japan")
        val c4 = Countries(4,"Russia")
        val c5 = Countries(5,"Germany")
        val c6 = Countries(6,"Spain")
        val c7 = Countries(7,"France")
        val c8 = Countries(8,"Portugal")
        val c9 = Countries(9,"England")
        val c10 = Countries(10,"China")

        countriesList = ArrayList<Countries>()
        countriesList.add(c1)
        countriesList.add(c2)
        countriesList.add(c3)
        countriesList.add(c4)
        countriesList.add(c5)
        countriesList.add(c6)
        countriesList.add(c7)
        countriesList.add(c8)
        countriesList.add(c9)
        countriesList.add(c10)

        recyclerViewAdapter = RecyclerViewAdapter(this, countriesList)
        bindingMain.recyclerView.adapter = recyclerViewAdapter



    }
}