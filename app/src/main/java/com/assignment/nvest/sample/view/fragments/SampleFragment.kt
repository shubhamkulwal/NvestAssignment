package com.assignment.nvest.sample.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.assignment.nvest.R
import com.assignment.nvest.base.BaseFragment
import com.assignment.nvest.databinding.FragmentSampleBinding
import com.assignment.nvest.sample.viewmodel.SampleViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject


class SampleFragment : BaseFragment() {
    override fun layoutRes(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var binding: FragmentSampleBinding? = null
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val sampleViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SampleViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sample,
            container,
            false
        )
        return binding?.let { fragmentSampleBinding -> binding!!.root }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sampleViewModel.fetchSampleData()
        // Explanation of observing data from viewmodel
        /*sampleViewModel.processedData.observe(
            this,
            Observer {
                binding!!.rvSample.apply {
                    adapter = SampleAdapter(it)
                }
                Log.e("Observed Result", ":" + it?.let { it -> it[0].getId() })
            })*/
    }

    override fun onDetach() {
        sampleViewModel.tearDown()
        super.onDetach()
    }

    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String?) {
        val requestOptions = RequestOptions()
//        requestOptions.placeholder(com.assignment.nvest.R.mipmap.ic_launcher)
//        requestOptions.error(com.assignment.nvest.R.mipmap.ic_launcher)
//        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE)
        if (url != null && (url.contains("https://") || url.contains("http://"))) {
            Glide.with(imageView.getContext()).setDefaultRequestOptions(requestOptions).load(url).into(imageView)
        }
    }
}