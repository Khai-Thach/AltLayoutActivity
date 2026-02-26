package edu.temple.fancyscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.profile_photo).setImageResource(R.drawable.istockphoto)

        findViewById<TextView>(R.id.name).setText(R.string.profile_name)

        with(findViewById<TextView>(R.id.email)) {
            setText(R.string.profile_email)
            setTextColor(Color.BLUE)
        }

        findViewById<TextView>(R.id.extension).setText(R.string.profile_extension)

        findViewById<TextView>(R.id.department).setText(R.string.profile_department)

        findViewById<TextView>(R.id.supervisor).setText(R.string.profile_supervisor)

        with (findViewById<RecyclerView>(R.id.directReportsRecyclerView)) {
            adapter = RecyclerViewAdapter(
                arrayOf(
                    getString(R.string.report_1),
                    getString(R.string.report_2),
                    getString(R.string.report_3),
                    getString(R.string.report_4),
                    getString(R.string.report_5),
                    getString(R.string.report_6)
                )
            )
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}

class RecyclerViewAdapter (private val staffList: Array<String>) : RecyclerView.Adapter<RecyclerViewAdapter.StaffListViewHolder>() {
    class StaffListViewHolder(val textView: TextView) : ViewHolder(textView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffListViewHolder {
        return StaffListViewHolder(
            TextView(parent.context).apply {
                textSize = 22f
                setTextColor(Color.BLUE)
                setPadding(50,8,0,8)
            }
        )
    }

    override fun getItemCount() = staffList.size

    override fun onBindViewHolder(holder: StaffListViewHolder, position: Int) {
        holder.textView.text = staffList[position]
    }
}