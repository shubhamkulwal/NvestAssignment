package com.assignment.nvest.di.modules

import com.assignment.nvest.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
open abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun binding(): MainActivity
}