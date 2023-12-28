package com.example.youpport

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton

class SupportProjectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_support_project, container, false)

        val btnProjectAll = view.findViewById<AppCompatButton>(R.id.btn_project_all)
        val btnProjectHousingIncome = view.findViewById<AppCompatButton>(R.id.btn_project_housing_income)
        val btnProjectEducationEmployment = view.findViewById<AppCompatButton>(R.id.btn_project_education_employment)
        val btnProjectEtc = view.findViewById<AppCompatButton>(R.id.btn_project_etc)

        val allButtons = listOf(btnProjectAll, btnProjectHousingIncome, btnProjectEducationEmployment, btnProjectEtc)

        // 초기에 모든 버튼의 isSelected를 false로 설정
        allButtons.forEach { it.isSelected = false }

        btnProjectAll.setOnClickListener {
            updateButtonState(btnProjectAll, allButtons)
        }

        btnProjectHousingIncome.setOnClickListener {
            updateButtonState(btnProjectHousingIncome, allButtons)
        }

        btnProjectEducationEmployment.setOnClickListener {
            updateButtonState(btnProjectEducationEmployment, allButtons)
        }

        btnProjectEtc.setOnClickListener {
            updateButtonState(btnProjectEtc, allButtons)
        }

        return view
    }

    private fun updateButtonState(selectedButton: AppCompatButton, allButtons: List<AppCompatButton>) {
        // 선택된 버튼 이외의 모든 버튼의 isSelected를 false로 설정
        allButtons.filterNot { it == selectedButton }.forEach {
            it.isSelected = false
        }

        // 선택된 버튼의 isSelected를 토글
        selectedButton.isSelected = !selectedButton.isSelected

        // 모든 버튼의 배경을 업데이트
        allButtons.forEach {
            it.setBackgroundResource(if (it.isSelected) R.drawable.category_button_checked else R.drawable.category_button_unchecked)
        }
    }
}
