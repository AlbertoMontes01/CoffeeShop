package com.example.coffeeshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.databinding.FragmentDetailsCoffeeBinding
import com.example.coffeeshop.databinding.FragmentFinalOrderBinding
import com.example.coffeeshop.model.OrderViewModel

class FinalOrderFragment : Fragment() {

    private var binding: FragmentFinalOrderBinding? = null

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentFinalOrderBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel

            lifecycleOwner = viewLifecycleOwner

            finalOrder = this@FinalOrderFragment
        }
    }

    fun sendData() {
        val numberOfCoffees= sharedViewModel.quantity.value

        val orderSummary = getString(
            R.string.order_details,
            resources.getQuantityString(R.plurals.coffees, numberOfCoffees!!, numberOfCoffees),
            sharedViewModel.description.value,
            sharedViewModel.estimatedTime.value,
            sharedViewModel.price.value.toString()
        )

        // Create an ACTION_SEND implicit intent with order details in the intent extras
        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT,getString(R.string.coffee_order))
            .putExtra(Intent.EXTRA_TEXT, orderSummary)

        // Check if there's an app that can handle this intent before launching it
        if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
            startActivity(intent)
        }
    }

    fun goBack() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.finalOrderFragment_to_startFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}