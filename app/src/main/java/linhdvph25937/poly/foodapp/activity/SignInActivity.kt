package linhdvph25937.poly.foodapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import linhdvph25937.poly.foodapp.R
import linhdvph25937.poly.foodapp.databinding.ActivitySignInBinding

private lateinit var binding: ActivitySignInBinding
class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goBack()//Return previous event
        goToSignUp()//Move to SignUp activity
    }


    private fun goToSignUp() {
        binding.tvGoToSignUp.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        }
    }
    private fun goBack() {
        binding.arrowBack.setOnClickListener {
            finish()
        }
    }
}