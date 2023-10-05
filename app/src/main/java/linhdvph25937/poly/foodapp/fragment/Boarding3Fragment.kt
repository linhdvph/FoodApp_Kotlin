package linhdvph25937.poly.foodapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import linhdvph25937.poly.foodapp.R
import linhdvph25937.poly.foodapp.activity.MainActivity
import linhdvph25937.poly.foodapp.databinding.FragmentBoarding3Binding

class Boarding3Fragment : Fragment() {
    private lateinit var binding: FragmentBoarding3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBoarding3Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            Boarding3Fragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}