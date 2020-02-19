package com.assignment.nvest.base

import com.assignment.nvest.di.ApplicationComponent
import com.assignment.nvest.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component: ApplicationComponent = DaggerApplicationComponent.builder().application(this).build()
        component.inject(this)
        return component

    }

}