package linhdvph25937.poly.foodapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import linhdvph25937.poly.foodapp.R
import linhdvph25937.poly.foodapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goBack()//Return previous event
        goToSignUp()//Move to SignUp activity
    }
    private fun goToSignUp() {
        binding.tvGoToSignIn.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        }
    }
    private fun goBack() {
        binding.arrowBack.setOnClickListener {
            finish()
        }
    }
}