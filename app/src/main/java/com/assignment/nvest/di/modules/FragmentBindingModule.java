package com.assignment.nvest.di.modules;

import com.assignment.nvest.sample.view.fragments.SampleFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract SampleFragment provideSampleFragment();


}