package com.example.islami.ui.dialoge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AboutUsSheet:BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.about_use_sheet,container,false)
    }
}