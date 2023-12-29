package com.example.youpport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youpport.R
import com.example.youpport.ProjectDto

class SupportProjectAdapter : RecyclerView.Adapter<SupportProjectAdapter.ProjectViewHolder>() {

    private var data: List<ProjectDto> = listOf()

    // setData 메서드 수정
    fun setData(newData: List<ProjectDto>?) {
        data = newData ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_support_project, parent, false)
        return ProjectViewHolder(view)
    }

    inner class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_name: TextView = itemView.findViewById(R.id.tv_name)
        val tv_region: TextView = itemView.findViewById(R.id.tv_region)
        val tv_organization: TextView = itemView.findViewById(R.id.tv_organization)
        val tv_start_period: TextView = itemView.findViewById(R.id.tv_start_period)
        val tv_end_period: TextView = itemView.findViewById(R.id.tv_end_period)
        // TODO: 다른 필드에 대한 초기화

        // 예를 들어, ImageView에 대한 초기화`
        // val imageView: ImageView = itemView.findViewById(R.id.iv_member)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val currentItem = data[position]

        // 이름 설정
        holder.tv_name.text = currentItem.name

        // 지역 설정
        holder.tv_region.text = currentItem.region

        // 기관 설정
        holder.tv_organization.text = currentItem.organization

        // 시작 기간 설정
        holder.tv_start_period.text = currentItem.startPeriod

        // 종료 기간 설정
        holder.tv_end_period.text = currentItem.endPeriod

        // TODO: 다른 필드에 대한 설정 추가

        // 예를 들어, ImageView에 이미지를 설정하려면 아래와 같이 사용
        // Glide 또는 Picasso 같은 이미지 로딩 라이브러리를 사용하는 것이 좋습니다.
        // Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
