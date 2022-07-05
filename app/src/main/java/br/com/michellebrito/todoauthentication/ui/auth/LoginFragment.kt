package br.com.michellebrito.todoauthentication.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import br.com.michellebrito.todoauthentication.R
import br.com.michellebrito.todoauthentication.databinding.LoginFragmentBinding
import br.com.michellebrito.todoauthentication.ui.utils.hideKeyboard

class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModel()
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)

        setupViewListeners()
        subscribeViewModelEvents()

        return binding.root
    }

    private fun setupViewListeners() {
        observeInputs()
        login()
    }

    private fun login() = with(binding) {
        BTNLogin.setOnClickListener {
            hideKeyboard()
            clearErrorOnEditText()
            viewModel.login(ETemail.text.toString(), ETpassword.text.toString())
        }
    }

    private fun observeInputs() = with(binding) {
        ETemail.doAfterTextChanged { viewModel.onEmailTextChanged(it) }
        ETpassword.doAfterTextChanged { viewModel.onPasswordTextChanged(it) }
    }

    private fun subscribeViewModelEvents() {
        viewModel.loginSuccess.observe(viewLifecycleOwner) { success ->
            when {
                success -> findNavController().navigate(R.id.action_loginFragment_to_taskListFragment)
                else -> setErrorOnEditText()
            }
        }

        viewModel.enableButton.observe(viewLifecycleOwner) { isEnabledForm ->
            binding.BTNLogin.isEnabled = isEnabledForm
        }
    }

    private fun setErrorOnEditText() = with(binding) {
        ETemail.error = getString(R.string.email_error)
        ETpassword.error = getString(R.string.password_error)
    }

    private fun clearErrorOnEditText() = with(binding) {
        ETemail.error = null
        ETpassword.error = null
    }
}