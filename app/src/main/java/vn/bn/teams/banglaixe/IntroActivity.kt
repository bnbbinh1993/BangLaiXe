package vn.bn.teams.banglaixe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vn.bn.teams.banglaixe.adapters.IntroPagerAdapter
import vn.bn.teams.banglaixe.databinding.ActivityIntroBinding
import vn.bn.teams.banglaixe.utils.Pref
import vn.bn.teams.banglaixe.utils.Tools

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    private val introAdapter = IntroPagerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Pref.getBoolean(this, Pref.INTRO, false)) {
            startToMain()
        } else {
            initViewpager()
        }


    }

    private fun initViewpager() {
        binding.apply {
            slideViewPager.adapter = introAdapter
            slideViewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {

                }
            })
            slideViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {

                    binding.nextButton.text =
                        if (position == Tools.getListIntro().size - 1) "Xong" else "Tiếp tục"

                }

            })

            dotIndicator.attachTo(slideViewPager)

            nextButton.setOnClickListener {
                val nextItem = slideViewPager.currentItem + 1
                if (nextItem < introAdapter.itemCount) {
                    slideViewPager.setCurrentItem(nextItem, true)
                } else {
                    Pref.setBoolean(this@IntroActivity, Pref.INTRO, true)
                    startToMain()
                }
            }
            backButton.setOnClickListener {
                Pref.setBoolean(this@IntroActivity, Pref.INTRO, true)
                startToMain()
            }
        }
    }

    private fun startToMain() {
        startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        finish()
    }


}