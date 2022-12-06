package net.sherafatpour.leancorn.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import dagger.hilt.android.AndroidEntryPoint
import net.sherafatpour.leancorn.R
import net.sherafatpour.leancorn.databinding.FragmentSplashBinding

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val viewModel: SplashViewModel by viewModels()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        viewModel.shouldGoToHome.asLiveData().observe(viewLifecycleOwner) { shouldGoToHome ->

            if (shouldGoToHome) {
                val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()

                findNavController().navigate(
                    action, NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
                )

            }
        }


        return binding.root;
    }

    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null;
    }

}