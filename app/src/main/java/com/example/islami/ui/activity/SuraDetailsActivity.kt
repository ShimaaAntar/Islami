package com.example.islami.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.adapter.AyaAdapter
import java.io.*

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var ayaAdapter: AyaAdapter
    lateinit var suraTitle:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        val fileName = intent.getStringExtra(Constants.EXTRA_SURA_FILE) ?: ""
        //  val ayat= fileName?.let {
        //     readSuraContant(it) }
        val ayat = readSuraContent(fileName)
        recyclerView=findViewById(R.id.ayarecyclerview)
        ayaAdapter = AyaAdapter(ayat)
        recyclerView.adapter=ayaAdapter
        suraTitle=findViewById(R.id.sure_title)
        suraTitle.text=suraName
    }

    fun readSuraContent(fileName: String): List<String> {
        var suraLines = mutableListOf<String>()

        val reader: BufferedReader

        try {
            val file = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line = reader.readLine()
            while (line != null) {
                suraLines.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return suraLines
    }
}


   /* private fun readSuraContant(fileName: String?): List<String>{
        val suraLine= mutableListOf<String>()
        val reader: BufferedReader
        try {
            val file = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
               // Log.d("StackOverflow", line)
                suraLine.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return suraLine

    }*/

