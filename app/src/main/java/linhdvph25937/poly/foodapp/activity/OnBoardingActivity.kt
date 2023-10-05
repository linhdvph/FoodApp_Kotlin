package linhdvph25937.poly.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import linhdvph25937.poly.foodapp.R
import linhdvph25937.poly.foodapp.adapter.BoardingAdapter
import linhdvph25937.poly.foodapp.databinding.ActivityOnBoardingBinding
import linhdvph25937.poly.foodapp.fragment.Boarding1Fragment
import linhdvph25937.poly.foodapp.fragment.Boarding2Fragment
import linhdvph25937.poly.foodapp.fragment.Boarding3Fragment

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPage2()
    }

    private fun setViewPage2() {
        var fragment = listOf(
            Boarding1Fragment(),
            Boarding2Fragment(),
            Boarding3Fragment()
        )

        val boardingAdapter = BoardingAdapter(supportFragmentManager, lifecycle, fragment)
        binding.viewPage2.adapter = boardingAdapter
        binding.dotsIndicator.attachTo(binding.viewPage2)
        binding.imgBack.setOnClickListener {
            binding.viewPage2.currentItem -= 1
        }
        binding.tvSkip.setOnClickListener {
            binding.viewPage2.currentItem = 2
        }
        binding.tvNext.setOnClickListener {
            binding.viewPage2.currentItem += 1
        }

        binding.viewPage2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0){
                    binding.imgBack.visibility = View.INVISIBLE
                    binding.tvSkip.visibility = View.VISIBLE
                    binding.tvNext.visibility = View.VISIBLE
                }else if (position == 2){
                    binding.imgBack.visibility = View.VISIBLE
                    binding.tvSkip.visibility = View.INVISIBLE
                    binding.tvNext.visibility = View.INVISIBLE
                    binding.dotsIndicator.visibility = View.INVISIBLE
                }else{
                    binding.imgBack.visibility = View.VISIBLE
                    binding.tvSkip.visibility = View.VISIBLE
                    binding.tvNext.visibility = View.VISIBLE
                    binding.dotsIndicator.visibility = View.VISIBLE
                }
            }
        })
    }
}