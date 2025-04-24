package com.example.appxin.TodoKotlin

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appxin.R

class TaskAdapter(
    private val tasks: MutableList<Task>,
    private val onTaskChecked: (Int, Boolean) -> Unit,
    private val onTaskDeleted: (Int) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cbTask: CheckBox = itemView.findViewById(R.id.cbTask)
        private val tvTaskTitle: TextView = itemView.findViewById(R.id.tvTaskTitle)
        private val ibDelete: ImageButton = itemView.findViewById(R.id.ibDelete)

        fun bind(task: Task) {
            tvTaskTitle.text = task.title
            cbTask.isChecked = task.isCompleted

            // Strike through text if task is completed
            if (task.isCompleted) {
                tvTaskTitle.paintFlags = tvTaskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                tvTaskTitle.paintFlags = tvTaskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }

            cbTask.setOnCheckedChangeListener { _, isChecked ->
                onTaskChecked(task.id, isChecked)
            }

            ibDelete.setOnClickListener {
                onTaskDeleted(task.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size
}