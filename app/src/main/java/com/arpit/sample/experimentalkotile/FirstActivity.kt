package com.arpit.sample.experimentalkotile

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.startup.AppInitializer
import androidx.work.*
import com.arpit.sample.experimentalkotile.databinding.ActivityFirstBinding
import com.arpit.sample.experimentalkotile.ui.dashboard.DashboardFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstActivity : AppCompatActivity() {


    private lateinit var viewModel: FirstActivityModelView
    private lateinit var binding: ActivityFirstBinding
    private lateinit var dataStore : DataStore<Preferences>


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(DashboardFragment.TAG, "onCreate" + this.javaClass.name)
        val bundle = Bundle()
        bundle.putString("KEY", "BOSS");
        supportFragmentManager.fragmentFactory = LocalFragmentFactory(bundle)
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       val appBarConfiguration = AppBarConfiguration(
               setOf(
                       R.id.navigation_home
               )
       )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.navSideView.setupWithNavController(navController)
        viewModel = ViewModelProvider(this).get(FirstActivityModelView::class.java)

        viewModel.liveDate.observe(this) {
            Log.i("myarpit", "state value from live data" + it)
        }
        val actionBar: ActionBar? = actionBar
        actionBar?.setCustomView(R.layout.custom_view_action_bar)
        actionBar?.displayOptions = (ActionBar.DISPLAY_SHOW_HOME
                or ActionBar.DISPLAY_SHOW_TITLE or ActionBar.DISPLAY_SHOW_CUSTOM)

        actionBar?.setHomeButtonEnabled(true)
        val intention = Intent(this, SampleIntentService::class.java)
        intention.setAction(SampleIntentService.INTENT1)
        startService(intention)

        intention.setAction(SampleIntentService.INTENT2)
        startService(intention)


        val data = Data.Builder().putInt("INPUT", 0).build()
        val request = OneTimeWorkRequest.Builder(SampleWorker::class.java)
                .setInputData(data)
                .addTag("WOKER")
                .build()

        var output: Int = -1
        val WorkManager = AppInitializer.getInstance(this).initializeComponent(CustomInitializerWorkManager::class.java)
        WorkManager.getWorkInfoByIdLiveData(request.id).observe(this) {
            if (it?.state == WorkInfo.State.SUCCEEDED) {
                output = it?.outputData.getInt("INPUT", -100)
                Log.i(SampleWorker.TAG, "result " + output)
            }
        }


        val request1 = OneTimeWorkRequest.Builder(SampleWorker::class.java)
                .addTag("WOKER")
                .build()

        WorkManager.beginWith(request).then(request1).enqueue()

        dataStore = this.createDataStore(name = "settings_pref")

        dataStore.data.asLiveData().observe(this){
            val value =it.get(key = IS_DARK_MODE)
            Log.i("DATASTORE", "value $value")
            if(value == null){
                test()
            }
        }

        Log.i(DashboardFragment.TAG, "onCreate end" + this.javaClass.name)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.i("sam11", "onCreateOptionsMenu")
        getMenuInflater().inflate(R.menu.custom_action_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("sam11", "onOptionsItemSelected")
        if(item.itemId == R.id.navigation_dashboard){
            item.setActionView(R.layout.progress);
            return true
        }
        return NavigationUI.onNavDestinationSelected(item!!,
                findNavController(R.id.nav_host_fragment))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        Log.i("sam11","onSupportNavigateUp" )
        onBackPressed()
        return true
    }

    fun test(){
        Log.i("DATASTORE", "set value")
        lifecycleScope.launch(Dispatchers.IO){
            dataStore.edit {
                it.set(IS_DARK_MODE, true)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("myarpit", "calling for saved instance")
        viewModel.setValue()
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        Log.i(DashboardFragment.TAG, "onstart" + this.javaClass.name)

        super.onStart()
    }

    override fun onStop() {
        Log.i(DashboardFragment.TAG, "onstop" + this.javaClass.name)
        super.onStop()
    }

    override fun onResume() {
        Log.i(DashboardFragment.TAG, "onResume" + this.javaClass.name)
        super.onResume()
    }

    companion object{
        val IS_DARK_MODE = preferencesKey<Boolean>("dark_mode")
    }

}


/*object SettingsSerializer : Serializer<SharedSettings> {
    override val defaultValue: SharedSettings = SharedSettings.getDefaultInstance()

    override fun readFrom(input: InputStream): SharedSettings {
        try {
            return SharedSettings.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(
        t: SharedSettings,
        output: OutputStream) = t.writeTo(output)
}*/
