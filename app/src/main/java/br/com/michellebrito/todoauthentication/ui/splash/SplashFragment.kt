package br.com.michellebrito.todoauthentication.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.michellebrito.domain.utils.Constants.DEFAULT_DELAY
import br.com.michellebrito.todoauthentication.R
import br.com.michellebrito.todoauthentication.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            delay(DEFAULT_DELAY)
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }
    }
}