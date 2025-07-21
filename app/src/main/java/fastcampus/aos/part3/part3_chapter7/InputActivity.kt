package fastcampus.aos.part3.part3_chapter7

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import fastcampus.aos.part3.part3_chapter7.databinding.ActivityInputBinding

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInputBinding

    private val viewModel: InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
            lifecycleOwner = this@InputActivity
            viewModel = this@InputActivity.viewModel
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.doneEvent.observe(this) {
            Toast.makeText(this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true

    }
}