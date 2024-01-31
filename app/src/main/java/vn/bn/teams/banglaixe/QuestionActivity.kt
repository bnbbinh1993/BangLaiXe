package vn.bn.teams.banglaixe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import vn.bn.teams.banglaixe.adapters.QuestionAdapter
import vn.bn.teams.banglaixe.databinding.ActivityQuestionBinding
import vn.bn.teams.banglaixe.models.Question
import vn.bn.teams.banglaixe.roomdata.learn.Contract
import vn.bn.teams.banglaixe.roomdata.learn.Presenter

class QuestionActivity : AppCompatActivity(), Contract.View {
    private lateinit var presenter: Contract.Presenter
    private lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = Presenter(this, this)
        presenter.getData(6, 20)
        initList()

    }

    private fun initList() {
        binding.apply {

            btnBack.setOnClickListener {
                finish()
            }

            viewPager.adapter = questionAdapter
            viewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {

                }
            })
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                @SuppressLint("SetTextI18n")
                override fun onPageSelected(position: Int) {
                    totals.text = (position + 1).toString() + "/" + questionAdapter.itemCount

                }

            })

            nextButton.setOnClickListener {
                val nextItem = viewPager.currentItem + 1
                if (nextItem < questionAdapter.itemCount) {
                    viewPager.setCurrentItem(nextItem, true)
                }
            }
            backButton.setOnClickListener {
                val nextItem = viewPager.currentItem - 1
                if (nextItem >= 0) {
                    viewPager.setCurrentItem(nextItem, true)
                }

            }


        }
    }

    var questionAdapter = QuestionAdapter()

    @OptIn(DelicateCoroutinesApi::class)
    override fun getTopic(list: List<Question>) {
        GlobalScope.launch(Dispatchers.Main) {
            questionAdapter.addData(list)
        }
    }
}