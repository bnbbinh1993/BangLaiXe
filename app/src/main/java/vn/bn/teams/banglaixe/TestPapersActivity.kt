package vn.bn.teams.banglaixe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vn.bn.teams.banglaixe.databinding.ActivityTestPapersBinding

class TestPapersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestPapersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestPapersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}