package com.example.appxin.TodoKotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appxin.R

class TaskActivity : AppCompatActivity() {
    private lateinit var etTask: EditText
    private lateinit var btnAdd: Button
    private lateinit var rvTasks: RecyclerView

    private val tasks = mutableListOf<Task>()
    private lateinit var taskAdapter: TaskAdapter
    private var taskIdCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        etTask = findViewById(R.id.etTask)
        btnAdd = findViewById(R.id.btnAdd)
        rvTasks = findViewById(R.id.rvTasks)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(
            tasks,
            onTaskChecked = { taskId, isChecked ->
                val task = tasks.find { it.id == taskId }
                task?.isCompleted = isChecked
                taskAdapter.notifyDataSetChanged()
            },
            onTaskDeleted = { taskId ->
                tasks.removeAll { it.id == taskId }
                taskAdapter.notifyDataSetChanged()
            }
        )

        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }
    private fun setupClickListeners() {
        btnAdd.setOnClickListener {
            val taskTitle = etTask.text.toString().trim()
            if (taskTitle.isNotEmpty()) {
                val newTask = Task(
                    id = taskIdCounter++,
                    title = taskTitle
                )
                tasks.add(newTask)
                taskAdapter.notifyItemInserted(tasks.size - 1)
                etTask.text.clear()
            } else {
                Toast.makeText(this, "Vui lòng nhập công việc", Toast.LENGTH_SHORT).show()
            }
        }
    }
}