package com.example.islami.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Constants
import com.example.islami.adapter.SuraAdapter
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.activity.SuraDetailsActivity
import com.example.islami.ui.dialoge.AboutUsSheet
import com.example.islami.ui.dialoge.HadethDetailsDialogue


class QuranFragment : Fragment() {
    val ArSuras = listOf(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )
    lateinit var binding: FragmentQuranBinding
    lateinit var suraAdapter: SuraAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        suraAdapter = SuraAdapter(ArSuras)
        //recyclerView.adapter=suraAdapter
        binding.recycleView.adapter = suraAdapter
        suraAdapter.onItemsClickListener = object : SuraAdapter.OnItemsClickListener {
            override fun onItemClick(position: Int, name: String) {
                startSuraDetailsActivity(position, name)
                //showImageDitailsDialoge()
            }
        }
//        binding.aboutUs.setOnClickListener{
//            showAboutus()
//        }


    }
    private fun startSuraDetailsActivity(position: Int, name: String) {
        val fileName = "" + (position + 1) + ".txt"
        val intent = Intent(context, SuraDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_SURA_NAME, name)
        intent.putExtra(Constants.EXTRA_SURA_FILE, fileName)
        startActivity(intent)
    }
}

//    private fun showAboutus() {
//        val sheetFragment=AboutUsSheet()
//        sheetFragment.show(childFragmentManager,"")
//    }
//
//    private fun showImageDitailsDialoge() {
//        val dailoge=HadethDetailsDialogue(position, model)
//        dailoge.show(childFragmentManager,"")
//    }



   /* override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        binding.notesRecyclerView.setVisibility(View.VISIBLE) //this hide/show recyclerview visibility
        Log.d("TAG", "hidden: ")
    }*/
