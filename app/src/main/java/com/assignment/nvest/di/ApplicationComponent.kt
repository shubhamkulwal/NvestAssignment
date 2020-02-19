package com.assignment.nvest.di

import android.app.Application
import com.assignment.nvest.base.BaseApplication
import com.assignment.nvest.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, ViewModelModule::class, ApplicationModule::class,ContextModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {
    fun inject(baseApplication: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}