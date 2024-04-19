import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3_5.R
import com.example.hw3_5.SecondFragment
import com.example.hw3_5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var count = 0
    private var isCountingUp = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.plusBtn.setOnClickListener {
            if (isCountingUp) {
                count++
                binding.tvCount.text = count.toString()
                if (count == 10) {
                    binding.plusBtn.text = "-1"
                    isCountingUp = false
                }
            } else {
                count--
                binding.tvCount.text = count.toString()
                if (count == 0) {
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.first_fragment, SecondFragment()).addToBackStack(null).commit()
                }
            }
        }
    }
}
