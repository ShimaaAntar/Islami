package com.example.islami.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.Constants
import com.example.islami.adapter.SuraAdapter
import com.example.islami.databinding.ActivitySouraListBinding

class SouraListActivity : AppCompatActivity() {
    val ArSuras= listOf("الفاتحه", "البقرة", "آل عمران", "النساء", "المائدة", "الأنعام", "الأعراف", "الأنفال", "التوبة", "يونس", "هود"
        , "يوسف", "الرعد", "إبراهيم", "الحجر", "النحل", "الإسراء", "الكهف", "مريم", "طه", "الأنبياء", "الحج", "المؤمنون"
        , "النّور", "الفرقان", "الشعراء", "النّمل", "القصص", "العنكبوت", "الرّوم", "لقمان", "السجدة", "الأحزاب", "سبأ"
        , "فاطر", "يس", "الصافات", "ص", "الزمر", "غافر", "فصّلت", "الشورى", "الزخرف", "الدّخان", "الجاثية", "الأحقاف"
        , "محمد", "الفتح", "الحجرات", "ق", "الذاريات", "الطور", "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة"
        , "الحشر", "الممتحنة", "الصف", "الجمعة", "المنافقون", "التغابن", "الطلاق", "التحريم", "الملك", "القلم", "الحاقة", "المعارج"
        , "نوح", "الجن", "المزّمّل", "المدّثر", "القيامة", "الإنسان", "المرسلات", "النبأ", "النازعات", "عبس", "التكوير", "الإنفطار"
        , "المطفّفين", "الإنشقاق", "البروج", "الطارق", "الأعلى", "الغاشية", "الفجر", "البلد", "الشمس", "الليل", "الضحى", "الشرح"
        , "التين", "العلق", "القدر", "البينة", "الزلزلة", "العاديات", "القارعة", "التكاثر", "العصر",
        "الهمزة", "الفيل", "قريش", "الماعون", "الكوثر", "الكافرون", "النصر", "المسد", "الإخلاص", "الفلق", "الناس"
    )
    lateinit var binding: ActivitySouraListBinding/////////////////////////////////
    lateinit var suraAdapter: SuraAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySouraListBinding.inflate(layoutInflater)////////////////////////////////
        //setContentView(R.layout.activity_soura_list)
        setContentView(binding.root)//////////////////////////////////////////////
       // recyclerView=findViewById(R.id.recycle_view)
        suraAdapter= SuraAdapter(ArSuras)
        //recyclerView.adapter=suraAdapter
        binding.recycleView.adapter=suraAdapter
        suraAdapter.onItemsClickListener=object: SuraAdapter.OnItemsClickListener{
            override fun onItemClick(position: Int, name: String) {
                startSuraDetailsActivity(position, name)
            }
        }
    }

            private fun startSuraDetailsActivity(position:Int,name:String) {
                val fileName=""+(position+1)+".txt"
                val intent=Intent(this@SouraListActivity, SuraDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_SURA_NAME,name)
                intent.putExtra(Constants.EXTRA_SURA_FILE,fileName)
                startActivity(intent)
            }

        }



