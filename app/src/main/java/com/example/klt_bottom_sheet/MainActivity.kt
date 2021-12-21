package com.example.klt_bottom_sheet

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.klt_bottom_sheet.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    private fun setupListener() {

        val sheetBehavior: BottomSheetBehavior<ConstraintLayout> =
            BottomSheetBehavior.from(binding.includeStandardSheet.standardSheet)

        binding.btnStandard.setOnClickListener {
            if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED)
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        }
        binding.btnModal.setOnClickListener { }
        binding.includeStandardSheet.imgStandard.setOnClickListener {
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        sheetBehavior.addBottomSheetCallback(
            object : BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {

                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    binding.includeStandardSheet.imgStandard.rotation = slideOffset * 180
                }

            }
        )

        binding.includeStandardSheet.tvA.setOnClickListener {
            Toast.makeText(this, "A", Toast.LENGTH_SHORT).show()
        }
        binding.includeStandardSheet.tvB.setOnClickListener {
            Toast.makeText(this, "B", Toast.LENGTH_SHORT).show()
        }
        binding.includeStandardSheet.tvC.setOnClickListener {
            Toast.makeText(this, "C", Toast.LENGTH_SHORT).show()
        }
        binding.includeStandardSheet.tvD.setOnClickListener {
            Toast.makeText(this, "D", Toast.LENGTH_SHORT).show()
        }


    }
}