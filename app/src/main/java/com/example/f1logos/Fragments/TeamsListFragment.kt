package com.example.f1logos.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.f1logos.*
import com.example.f1logos.databinding.FragmentTeamsListBinding
import java.util.*


class TeamsListFragment : Fragment() {

private val teamAdapter : TeamsAdapter by lazy {
    TeamsAdapter()

}

    private val matchedTeams = mutableListOf<TeamData>()


    private var _binding: FragmentTeamsListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
        rvItems.layoutManager =
            GridLayoutManager(requireContext(),3, GridLayoutManager.VERTICAL, false)
            rvItems.adapter = teamAdapter
            teamAdapter.submitList(teamCard)



            teamAdapter.apply {


                setOnDeleteClickListener{
                    teamData, i ->
                    val action = TeamsListFragmentDirections.actionTeamsListFragmentToTeamsDetailsFragment(
                        TeamData(
                            teamData.description,
                            teamData.name,
                            teamData.image
                        )
                    )
                    findNavController().navigate(action)

                }
            }
        }
        binding.btnSearch.setOnClickListener {
            teamAdapter.apply {
                val searchItem = binding.svSearch.text.toString().toLowerCase()


                teamCard.forEach {
                    if (it.name == searchItem) {
                        matchedTeams.add(it)
                        submitList(matchedTeams.toList())

                    }
                    else if (searchItem.isEmpty()){
                        matchedTeams.clear()
                        submitList(teamCard.toList())
                    }
                    else{

                    }
                    matchedTeams.clear()
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }

}
