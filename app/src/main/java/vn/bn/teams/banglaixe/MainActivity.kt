package vn.bn.teams.banglaixe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


import androidx.activity.result.contract.ActivityResultContracts

import vn.bn.teams.banglaixe.databinding.ActivityMainBinding
import vn.bn.teams.banglaixe.models.Question
import vn.bn.teams.banglaixe.roomdata.learn.Contract
import vn.bn.teams.banglaixe.roomdata.learn.Presenter


import vn.bn.teams.banglaixe.utils.Pref

class MainActivity : AppCompatActivity(), Contract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkFilter()

        presenter = Presenter(this, this)



        DataManager.initialize(this,  object : DataManager.OnLoadListener {
            override fun onSuccess() {
//                if (!presenter.checkRoomDb()) {
//                    presenter.insertData(DataManager.listQuestion)
//                }else{
//                    presenter.getData(1,10)
//                }



            }

            override fun onFailure(e: String) {
                //hihi
            }

        })






        binding.apply {
            layoutFilter.setOnClickListener {
                requestActivityResult.launch(Intent(this@MainActivity, FiltersActivity::class.java))
            }
            setting.setOnClickListener {
                requestActivityResult.launch(Intent(this@MainActivity, SettingActivity::class.java))
            }
            note.setOnClickListener {
                startActivity(Intent(this@MainActivity, LearningTheoryActivity::class.java))
            }
        }
    }


    private fun checkFilter() {
        val filter = Pref.getInt(this@MainActivity, Pref.FILTER, 0)
        if (filter != 0) {
            initData()
        } else {
            requestActivityResult.launch(Intent(this@MainActivity, FiltersActivity::class.java))
        }
    }

    private val requestActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val result = it.data
                val type = result!!.getStringExtra("type")
                if (!type.isNullOrEmpty()) {
                    when (type) {
                        Pref.REQUEST_FILTER -> {
                            val filter = result.getIntExtra("filter", 0)
                            if (filter != 0) {
                                Pref.setInt(this@MainActivity, Pref.FILTER, filter)
                                initData()
                                Log.d("__fil", "hhh: $filter")
                            }
                        }

                        Pref.REQUEST_SETTING -> {

                        }
                    }


                }

            }
        }

    private fun initData() {

    }

    override fun getTopic(list: List<Question>) {

    }


}