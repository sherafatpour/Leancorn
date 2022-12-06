package net.sherafatpour.leancorn

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import net.sherafatpour.leancorn.R
import net.sherafatpour.leancorn.databinding.ActivityMainBinding
import net.sherafatpour.leancorn.ui.splash.SplashViewModel


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}