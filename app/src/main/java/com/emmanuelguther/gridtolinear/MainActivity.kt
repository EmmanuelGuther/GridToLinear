package com.emmanuelguther.gridtolinear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myListData: Array<MyListData> = arrayOf<MyListData>(
                MyListData("Lorem", R.drawable.img1),
                MyListData("Ipsum", R.drawable.img2),
                MyListData("Dolor", R.drawable.img3),
                MyListData("Sit", R.drawable.img4),
                MyListData("Amet", R.drawable.img5),
                MyListData("Consectetur ", R.drawable.img6),
                MyListData("Adipiscing ", R.drawable.img7),
                MyListData("Elit ", R.drawable.img8),
                MyListData("Tellus ", R.drawable.img9),
                MyListData("Iaculis  ", R.drawable.img10),
                MyListData("Posuere   ", R.drawable.img11),
                MyListData("Cubilia  ", R.drawable.img12),
                MyListData("Libero   ", R.drawable.img13),
                MyListData("Vestibulum   ", R.drawable.img14)
        )
        setupRecyclerView(myListData)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list_representation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.list -> {
                GridToLinear().change(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupRecyclerView(myListData: Array<MyListData>) {
        GridToLinear().build(
                this,
                recyclerView,
                2,
                R.drawable.ic_grid_list_24dp,
                R.drawable.ic_list_white_24dp,
                resources.getDimension(R.dimen.margin_normal).toInt(),
                resources.getDimension(R.dimen.margin_grid).toInt()
        )
        val adapter = MyListAdapter()
        recyclerView.adapter = adapter
        adapter.collection = myListData.toList()

    }
}