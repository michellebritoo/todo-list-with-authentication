package br.com.michellebrito.todoauthentication.ui.taskList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import br.com.michellebrito.todoauthentication.R
import br.com.michellebrito.todoauthentication.databinding.TaskListFragmentBinding

class TaskListFragment : Fragment() {
    private lateinit var binding: TaskListFragmentBinding
    private val viewModel: TaskListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TaskListFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}