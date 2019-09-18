package com.create.nfraggle.diceroller

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.create.nfraggle.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var diceImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.dice_img)

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                this.setLifecycleOwner(this@MainActivity)
                this.viewModel = mainViewModel
            }

        val currentRoleValueObserver = Observer<Int> {
            var res = when (it) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            /**
             * I don't know why, but if I try and use the member variable (diceImg) and set the
             * image resource on that it doesn't work. I have to call findViewId each time in order
             * to update the view.
             */
            findViewById<ImageView>(R.id.dice_img).setImageResource(res)
        }

        mainViewModel.currentRollValue.observe(this, currentRoleValueObserver)
    }
}
