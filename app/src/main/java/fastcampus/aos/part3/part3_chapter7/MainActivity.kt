package fastcampus.aos.part3.part3_chapter7

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import fastcampus.aos.part3.part3_chapter7.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
            recyclerView.adapter = adapter
            val decoration = DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL)
            recyclerView.addItemDecoration(decoration)
        }

        lifecycleScope.launch {
            viewModel.contentList.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collectLatest {
                binding.emptyTextView.isVisible = it.isEmpty()
                binding.recyclerView.isVisible = it.isNotEmpty()
                adapter.submitList(it)
            }
        }
    }

    fun onClickAdd() {

    }
}