package com.example.youpport

import android.annotation.SuppressLint
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
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btnAll = view.findViewById<AppCompatButton>(R.id.btn_all)
        val btnHouInc = view.findViewById<AppCompatButton>(R.id.btn_hou_inc)
        val btnEduEmp = view.findViewById<AppCompatButton>(R.id.btn_edu_emp)
        val btnEtc = view.findViewById<AppCompatButton>(R.id.btn_etc)

        // 클릭 이벤트 공통 처리 함수
        fun navigateToSupportFragment(selectedButtonId: Int) {
            val supportProjectFragment = SupportProjectFragment()
            val args = Bundle()
            args.putInt("selectedButtonId", selectedButtonId)
            supportProjectFragment.arguments = args

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.HomeFragment, supportProjectFragment)
                .commit()
        }

        btnAll?.setOnClickListener { navigateToSupportFragment(R.id.btn_project_all) }
        btnHouInc?.setOnClickListener { navigateToSupportFragment(R.id.btn_project_housing_income) }
        btnEduEmp?.setOnClickListener { navigateToSupportFragment(R.id.btn_project_education_employment) }
        btnEtc?.setOnClickListener { navigateToSupportFragment(R.id.btn_project_etc) }

        return view
    }
}
