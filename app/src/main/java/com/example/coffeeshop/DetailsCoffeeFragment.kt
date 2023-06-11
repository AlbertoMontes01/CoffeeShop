package com.example.coffeeshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.databinding.FragmentDetailsCoffeeBinding
import com.example.coffeeshop.model.OrderViewModel

class DetailsCoffeeFragment : Fragment() {

    private var quantityPicker: NumberPicker? = null

    private var binding: FragmentDetailsCoffeeBinding? = null

    private var numberCoffees: Int? = null

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentDetailsCoffeeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quantityPicker = binding?.quantityPicker!!
        quantityPicker!!.maxValue = 9
        quantityPicker!!.minValue = 1
        binding?.apply {
            viewModel = sharedViewModel
            detailsFragment = this@DetailsCoffeeFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    fun goNext() {
        findNavController().navigate(R.id.detailsCoffeFragment_to_finalOrderFragment)
        numberCoffees = quantityPicker!!.value
        sharedViewModel.setQuantity(numberCoffees!!)
        sharedViewModel.updatePrice()
    }

    fun goBack() {
        findNavController().navigate(R.id.detailsCoffeFragment_to_startFragment)
        sharedViewModel.resetOrder()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}