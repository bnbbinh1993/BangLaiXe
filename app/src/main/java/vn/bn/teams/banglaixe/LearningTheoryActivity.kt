package vn.bn.teams.banglaixe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vn.bn.teams.banglaixe.databinding.ActivityLearningTheoryBinding

class LearningTheoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLearningTheoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearningTheoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnBack.setOnClickListener {
                finish()
            }
            topic1.setOnClickListener {
                startActivity(Intent(this@LearningTheoryActivity, QuestionActivity::class.java))
            }
        }
    }
}