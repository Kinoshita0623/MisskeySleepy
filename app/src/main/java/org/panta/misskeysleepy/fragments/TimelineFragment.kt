package org.panta.misskeysleepy.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.panta.misskeysleepy.R
import org.panta.misskeysleepy.adapters.TimelineAdapter
import org.panta.misskeysleepy.databinding.FragmentTimelineBinding
import org.panta.misskeysleepy.viewmodel.TimelineViewModel

class TimelineFragment : Fragment(){
    companion object{
        fun newInstance(): TimelineFragment{
            return TimelineFragment()
        }
    }

    private var mTimelineBinding: FragmentTimelineBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val binding = FragmentTimelineBinding.inflate(inflater, container, false)
        val binding = DataBindingUtil.inflate<FragmentTimelineBinding>(inflater, R.layout.fragment_timeline, container, false)
        mTimelineBinding = binding
        binding.adapter = TimelineAdapter()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(mTimelineBinding?.viewModel == null){
            mTimelineBinding?.viewModel = TimelineViewModel()
        }
    }
}