package com.arpit.sample.experimentalkotile.ui.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arpit.sample.experimentalkotile.FakeRepo
import com.arpit.sample.experimentalkotile.di.Repo1
import javax.inject.Inject

class FragmentModelViewFactory (private val repo : FakeRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(FakeRepo::class.java).newInstance(repo)
    }

}