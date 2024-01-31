package vn.bn.teams.banglaixe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vn.bn.teams.banglaixe.databinding.ActivityFiltersBinding
import vn.bn.teams.banglaixe.utils.Pref

class FiltersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFiltersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnBack.setOnClickListener {
                finish()
            }
            layoutA1.setOnClickListener {
                finishFilter(1)
            }
            layoutA2.setOnClickListener {
                finishFilter(2)
            }
            layoutA3.setOnClickListener {
                finishFilter(3)
            }
            layoutA4.setOnClickListener {
                finishFilter(4)
            }
        }



    }

    private fun finishFilter(i: Int) {
        val intent = Intent()
        intent.putExtra("filter",i)
        intent.putExtra("type", Pref.REQUEST_FILTER)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}