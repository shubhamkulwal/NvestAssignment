package com.assignment.nvest.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.nvest.di.util.ViewModelKey
import com.assignment.nvest.sample.viewmodel.SampleViewModel
import com.assignment.nvest.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    abstract fun bindListViewModel(listViewModel: SampleViewModel): ViewModel

   /* @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory*/
   @Binds
   internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
