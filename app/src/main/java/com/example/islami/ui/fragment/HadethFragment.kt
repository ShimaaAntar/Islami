package com.example.islami.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.adapter.HadethAdapter
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.model.Hadeth
import com.example.islami.ui.dialoge.HadethDetailsDialogue
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class HadethFragment: Fragment() {
    lateinit var binding: FragmentHadethBinding
    lateinit var hadethAdapter: HadethAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHadethBinding.inflate(layoutInflater ,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var hadethlist=readHadethContent()
        hadethAdapter= HadethAdapter(hadethlist)
        binding.recycleView.adapter=hadethAdapter
        hadethAdapter.onItemsClickListener=object:HadethAdapter.OnItemsClickListener{
            override fun onItemClick(position: Int, model: Hadeth) {
                showDialogDetailsHadegh(position, model)
            }
        }
    }
    private fun showDialogDetailsHadegh(position: Int, model: Hadeth) {
        val dailoge= HadethDetailsDialogue(position,model)
        dailoge.show(childFragmentManager,"")
    }



    private fun readHadethContent(): List<Hadeth> {


        var ahadethList= mutableListOf<Hadeth>()

        val reader: BufferedReader
        try {
            val file: InputStream? = activity?.assets?.open("ahadeth.txt")
            reader = BufferedReader(InputStreamReader(file))
            var line :String?= reader.readLine()
            while (line != null) {

                val title=line

                line = reader.readLine()

                var content =""
                while (!line.equals("#")){
                    content+=line+" "
                    line=reader.readLine()

                }
                line = reader.readLine()
                val hadeth=Hadeth(title = title, content = content)
                ahadethList.add(hadeth)
                Log.e("title",title)
                Log.e("content",content)
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return ahadethList
    }

}