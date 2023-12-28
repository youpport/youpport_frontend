package com.example.youpport

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil.setContentView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // findViewById 대신 view.findViewById 사용
        val btnAll = view.findViewById<AppCompatButton>(R.id.btn_all)

        if (btnAll != null) {
            btnAll.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.HomeFragment,
                        SupportProjectFragment()
                    )
                    .commit()
            }
        }

        return view
    }
}


