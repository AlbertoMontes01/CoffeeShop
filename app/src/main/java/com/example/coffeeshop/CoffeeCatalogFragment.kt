package com.example.coffeeshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.databinding.FragmentCoffeeCatalogBinding
import com.example.coffeeshop.model.OrderViewModel

class CoffeeCatalogFragment : Fragment() {

    private var binding: FragmentCoffeeCatalogBinding? = null

    private val sharedViewModel: OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragmentBinding = FragmentCoffeeCatalogBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            coffeeCatalogFragment = this@CoffeeCatalogFragment
        }
    }

    fun goNext(Id: Int) {
        when (Id) {
            1 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())
                sharedViewModel.setDescription(getString(R.string.description_black_coffee))
                sharedViewModel.setImage(R.drawable.black_coffee)
                sharedViewModel.setName(getString(R.string.black_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_one))

            }

            2 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())
                sharedViewModel.setDescription(getString(R.string.description_latte_coffee))
                sharedViewModel.setImage(R.drawable.best_coffee)
                sharedViewModel.setName(getString(R.string.latte_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_three))

            }

            3 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())
                sharedViewModel.setDescription(getString(R.string.description_cappuccino_coffee))
                sharedViewModel.setImage(R.drawable.coffee)
                sharedViewModel.setName(getString(R.string.cappuccino_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_two))

            }

            4 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())
                sharedViewModel.setDescription(getString(R.string.description_americano_coffee))
                sharedViewModel.setImage(R.drawable.delicious_coffee)
                sharedViewModel.setName(getString(R.string.americano_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_one))
            }

            5 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())
                sharedViewModel.setDescription(getString(R.string.description_espresso_coffee))
                sharedViewModel.setImage(R.drawable.especial_coffee)
                sharedViewModel.setName(getString(R.string.espresso_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_three))

            }

            6 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())

                sharedViewModel.setDescription(getString(R.string.description_doppio_coffee))
                sharedViewModel.setImage(R.drawable.high_coffee)
                sharedViewModel.setName(getString(R.string.doppio_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_two))

            }

            7 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())

                sharedViewModel.setDescription(getString(R.string.description_red_eye_coffee))
                sharedViewModel.setImage(R.drawable.hot_coffee)
                sharedViewModel.setName(getString(R.string.red_eye_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_two))
            }

            8 -> {
                sharedViewModel.setQuantity(getString(R.string.one).toInt())

                sharedViewModel.setDescription(getString(R.string.description_macchiato_coffee))
                sharedViewModel.setImage(R.drawable.late_coffee)
                sharedViewModel.setName(getString(R.string.macchiato_coffee))
                sharedViewModel.setEstimatedTime(getString(R.string.time_three))

            }
        }
        findNavController().navigate(R.id.coffeCatalogFragment_to_detailsCoffeFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}