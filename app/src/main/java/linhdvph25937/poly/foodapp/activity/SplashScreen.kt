package linhdvph25937.poly.foodapp.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import linhdvph25937.poly.foodapp.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private var isFirstLaunchApp = true
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("Bau", Context.MODE_PRIVATE)
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            delay(3000)
            checkisFirstime()
        }
    }

    private fun checkisFirstime(){
        isFirstLaunchApp = sharedPreferences.getBoolean("isFirstTime", true)
        if (isFirstLaunchApp){
            startActivity(Intent(this@SplashScreen, OnBoardingActivity::class.java))
            editor = sharedPreferences.edit()
            editor.putBoolean("isFirstTime", false)
            editor.commit()
        }else{
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
        }
    }
}