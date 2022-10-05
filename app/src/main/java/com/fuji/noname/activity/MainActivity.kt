package com.fuji.noname.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.fuji.noname.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    //การสร้างตัวแปรไว้สำหรับทำงานกับ   View Biding
    lateinit var navController: NavController// Control Navigation
    lateinit var appBarConfiguration: AppBarConfiguration// อ่านค่าจาก UI  Navigation Component
    lateinit var navHostFragment: NavHostFragment// Manage host of fragment
    lateinit var mainDrawerLayout: DrawerLayout// Manage Drawer Menu
    lateinit var mainToolbar: Toolbar// Manage Toolbar
    lateinit var mainNavigationView: NavigationView// Manege Navigation View
    lateinit var mainBottomNavigationView: BottomNavigationView// Manege Bottom Menu


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Inlet (Find View)
        mainToolbar = findViewById(R.id.main_toolbar)
        mainDrawerLayout = findViewById(R.id.drawer_layout)
        mainNavigationView = findViewById(R.id.main_navigation_view)
        mainBottomNavigationView = findViewById(R.id.main_bottom_navigation_view)

        //กำหนดการเริ่มต้นใหม่ ให้กับ Nav Controller
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        navController = navHostFragment.navController


        //การกำหนด  appBar configuration initial
        appBarConfiguration = AppBarConfiguration.Builder(
            //กำหนด  Fragment ที่ไม่้ต้องการให้ปุ่ม Back เกิดขึ้น
            R.id.homeFragment,
            R.id.assignMentFragment,
            R.id.usingCarFragment,
            R.id.planEngineerFragment,
            R.id.notificaTionFragment
        ).setOpenableLayout(mainDrawerLayout).build()


        //เรียก ใช้งาน main menu Toolbar
        setSupportActionBar(mainToolbar)

        //กำหนดให้ Toolbar  to display  icon menu
        setupActionBarWithNavController(navController, appBarConfiguration)
        //เรยกใช้งาน Drawer navigation
        mainNavigationView.setupWithNavController(navController)


        // เรียกใช้ mainBottom Navigation
        mainBottomNavigationView.setupWithNavController(navController)
    }

    //ทำการ Override method onSupport Navigate เพื่อจัดการ menu
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}