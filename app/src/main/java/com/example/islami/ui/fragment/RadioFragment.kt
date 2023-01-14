package com.example.islami.ui.fragment

import android.content.DialogInterface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Base.BaseFragment
import com.example.islami.adapter.HadethAdapter
import com.example.islami.adapter.RadioAdapter
import com.example.islami.api.ApiManager
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.databinding.FragmentRadioBinding
import com.example.islami.model.Hadeth
import com.example.islami.model.RadioResponse
import com.example.islami.model.RadiosChannel
import com.example.islami.ui.dialoge.HadethDetailsDialogue
import retrofit2.Call
import retrofit2.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import javax.security.auth.callback.Callback


class RadioFragment: BaseFragment() {
    lateinit var binding: FragmentRadioBinding
    lateinit var adapter: RadioAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRadioBinding.inflate(layoutInflater ,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        ApiManager.getApis()
            .getRadioChannels()
            .enqueue(object :retrofit2.Callback<RadioResponse>{
                //response from server
                override fun onResponse(
                    call: Call<RadioResponse>,
                    response: Response<RadioResponse>
                ) {
                    binding.progressBar.visibility=View.GONE
                    if (response.isSuccessful){
                        val data=response.body()
                        adapter.changeData(data?.radios)
                        Log.e("data",data.toString())
                    }
                }
                // fail can't to server
                override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                    showDialoge(message = "internet issue"+ t.localizedMessage,
                    posActionName = "ok",
                    posAction = DialogInterface.OnClickListener{dialog,which ->
                        //call.enqueue(this)
                        dialog.dismiss()
                    })
                }

            })
    }

    private fun setRecyclerView() {
        adapter= RadioAdapter(null)
        binding.recycleView.adapter=adapter
        adapter.onPlayClickListener=
            object :RadioAdapter.OnItemClickListener{
                override fun onItemClick(position: Int, radioChannel: RadiosChannel) {
                    playRadio(radioChannel.url!!)
                }

            }
        adapter.onStopClickListener=
            object :RadioAdapter.OnItemClickListener{
                override fun onItemClick(position: Int, radioUrl: RadiosChannel) {
                    stopRadio()
                }

            }

    }
    var mediaPlayer=MediaPlayer()
    fun playRadio(url:String){
        stopRadio()
        mediaPlayer.setDataSource(activity!!,Uri.parse(url))
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener{
            it.start()
        }
    }
    fun stopRadio(){
        if (mediaPlayer.isPlaying)
            mediaPlayer.stop()
        mediaPlayer.reset()
    }


}