package com.escobar.dummydictionary.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.escobar.dummydictionary.*
import com.escobar.dummydictionary.databinding.FragmentWordListBinding
import com.escobar.dummydictionary.repository.DictionaryRepository

class WordListFragment : Fragment() {

    private val viewModelFactory by lazy {
        val application = requireActivity().application as DummyDictionaryApplication
        WordViewModelFactory(application.getDictionaryRepository())
    }

    private val viewModel: WordViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_word_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wordListRecyclerView = binding.wordListRecyclerView
        val wordAdapter = WordAdapter()
        wordListRecyclerView.apply {
            adapter = wordAdapter
        }

        viewModel.words.observe(viewLifecycleOwner) { data ->
            wordAdapter.setData(data)
        }

        val navController = findNavController()
        binding.actionAddWord.setOnClickListener {
            val action = WordListFragmentDirections.actionWordListFragmentToAddWordFragment()
            navController.navigate(action)
        }
    }


}