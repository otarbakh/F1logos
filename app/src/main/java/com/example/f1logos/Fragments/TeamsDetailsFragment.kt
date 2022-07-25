package com.example.f1logos.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.f1logos.databinding.FragmentTeamsDetailsBinding



class TeamsDetailsFragment : Fragment() {
    private var _binding: FragmentTeamsDetailsBinding? = null
    private val binding get() = _binding!!

    val args: TeamsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamsDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvId.text = args.teamLogo.description.toString()
        binding.tvWelcome.text = args.teamLogo.name
        binding.ImLogo.setImageResource(args.teamLogo.image)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }

}