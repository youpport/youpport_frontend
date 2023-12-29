package com.example.youpport

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SupportProjectFragment : Fragment() {

    private lateinit var selectedButton: AppCompatButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SupportProjectAdapter

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

        // 버튼에 카테고리 이름 추가
        btnProjectAll.tag = "All"
        btnProjectHousingIncome.tag = "HousingIncome"
        btnProjectEducationEmployment.tag = "EducationEmployment"
        btnProjectEtc.tag = "Etc"

        // 선택된 버튼이 있으면 해당 버튼을 선택 상태로 설정
        val selectedButtonId = arguments?.getInt("selectedButtonId", -1)
        selectedButton = when (selectedButtonId) {
            R.id.btn_project_all -> btnProjectAll
            R.id.btn_project_housing_income -> btnProjectHousingIncome
            R.id.btn_project_education_employment -> btnProjectEducationEmployment
            R.id.btn_project_etc -> btnProjectEtc
            else -> btnProjectAll // 기본값은 btnProjectAll로 설정
        }

        selectedButton.isSelected = true
        selectedButton.setBackgroundResource(R.drawable.category_button_checked)

        // 버튼 클릭 리스너 설정
        btnProjectAll.setOnClickListener {
            updateButtonState(btnProjectAll, allButtons)
            fetchDataForSelectedCategory(btnProjectAll, "All")
        }
        btnProjectHousingIncome.setOnClickListener {
            updateButtonState(btnProjectHousingIncome, allButtons)
            fetchDataForSelectedCategory(btnProjectHousingIncome, "HousingIncome")
        }
        btnProjectEducationEmployment.setOnClickListener {
            updateButtonState(btnProjectEducationEmployment, allButtons)
            fetchDataForSelectedCategory(btnProjectEducationEmployment, "EducationEmployment")
        }
        btnProjectEtc.setOnClickListener {
            updateButtonState(btnProjectEtc, allButtons)
            fetchDataForSelectedCategory(btnProjectEtc, "Etc")
        }

        // 리사이클러뷰 초기화
        recyclerView = view.findViewById(R.id.rv_support_project)
        adapter = SupportProjectAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // 선택된 버튼이 변할 때 fetchDataForSelectedCategory 호출
        if (selectedButton.isSelected) {
            val category = selectedButton.tag as? String
            category?.let {
                fetchDataForSelectedCategory(selectedButton, it)
            }
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

    private fun fetchDataForSelectedCategory(selectedButton: AppCompatButton, category: String?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://34.22.95.241:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ProjectApiService::class.java)

        if (!category.isNullOrEmpty()) {
            val endpoint = "$category"

            val call = apiService.getDataByCategory(endpoint)

            call.enqueue(object : Callback<List<List<ProjectDto>>> {
                override fun onResponse(
                    call: Call<List<List<ProjectDto>>>,
                    response: Response<List<List<ProjectDto>>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        Log.d("SupportProjectFragment", "API 응답: $data")
                        displayData(data)
                    } else {
                        Log.e("SupportProjectFragment", "서버 응답 실패: ${response.code()}")
                        displayError("서버 응답 실패")
                    }
                }

                override fun onFailure(call: Call<List<List<ProjectDto>>>, t: Throwable) {
                    displayError("API call failed: ${t.message}")
                }
            })
        }
    }

    private fun displayData(data: List<List<ProjectDto>>?) {
        if (data != null) {
            val flattenedData = data.flatten()
            adapter.setData(flattenedData)
            adapter.notifyDataSetChanged()
        }
    }

    private fun displayError(message: String) {
        Log.e("SupportProjectFragment", message)
    }
}
