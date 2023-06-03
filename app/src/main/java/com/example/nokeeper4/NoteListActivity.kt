package com.example.nokeeper4

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.nokeeper4.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding
    private lateinit var listNotes: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listNotes = findViewById(R.id.listNotes)

        binding.fab.setOnClickListener {
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }
        listNotes.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            DataManager.notes)

        listNotes.setOnItemClickListener { _, _, position, _ ->
            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.putExtra(NOTE_POSITION, position)
            startActivity(activityIntent)

        }
    }

    override fun onResume() {
        super.onResume()
        (listNotes.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }
}