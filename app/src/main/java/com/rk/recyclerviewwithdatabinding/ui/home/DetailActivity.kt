package com.rk.recyclerviewwithdatabinding.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rk.recyclerviewwithdatabinding.R

import com.rk.recyclerviewwithdatabinding.data.response.HealthItem
import com.rk.recyclerviewwithdatabinding.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val healthItem = intent.extras?.get("data") as HealthItem

      // val healthItem : HealthItem
       val binding: ActivityDetailBinding
       = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        ///binding.setTemp(temperatureData);
        if (binding!= null) {
            binding.health=healthItem

        }

    }
}