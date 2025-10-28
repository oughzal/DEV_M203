package com.example.m203

import android.graphics.Color
import android.os.Bundle
import android.view.ActionMode
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity


import androidx.appcompat.widget.PopupMenu
import com.example.m203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var mActionMode : ActionMode? = null

    private val mActionModeCallback: ActionMode.Callback = object : ActionMode.Callback{
        override fun onCreateActionMode(
            mode: ActionMode?,
            menu: Menu?
        ): Boolean {
            menuInflater.inflate(R.menu.menu_option,menu)
            return true
        }

        override fun onPrepareActionMode(
            mode: ActionMode?,
            menu: Menu?
        ): Boolean {
            return false
        }

        override fun onActionItemClicked(
            mode: ActionMode?,
            item: MenuItem?
        ): Boolean {
            when(item?.itemId){
                else-> false
            }
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            //code to execute when action mode is closed
            mActionMode = null
        }
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        registerForContextMenu(binding.tvShowContextMenu)

        binding.btnShowPopupMenu.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.menuInflater.inflate(R.menu.menu_options, popupMenu.menu)
          popupMenu.setOnMenuItemClickListener {
              when(it.itemId) {
                  R.id.option1 -> {
                      binding.root.setBackgroundColor(0xffeeeeee.toInt())
                      true
                  }
                  else -> false
              }
          }
            popupMenu.show()
        }

        binding.btnActionMode.setOnClickListener {
            if(mActionMode == null){
                mActionMode = startActionMode(mActionModeCallback)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.option1 -> {
                binding.root.setBackgroundColor(Color.RED)
                return true
            }
            R.id.option2 -> {
                binding.root.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.option3 -> {
                binding.root.setBackgroundColor(Color.BLUE)
                return true
            }
        }
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.menu_options,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return true
    }
}