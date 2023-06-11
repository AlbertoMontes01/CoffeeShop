package com.example.coffeeshop.model

import android.media.Image
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeshop.R

private const val PRICE_PER_COFFEE = 14.00

class OrderViewModel : ViewModel() {
    private val _quantity = MutableLiveData<Int>()
    var quantity: LiveData<Int> = _quantity

    private val _price = MutableLiveData<Double>()
    var price: LiveData<Double> = _price

    private val _name = MutableLiveData<String>()
    var name: LiveData<String> = _name

    private val _ingredients = MutableLiveData<String>()
    var ingredients: LiveData<String> = _ingredients

    private val _description = MutableLiveData<String>()
    var description: LiveData<String> = _description

    private val _estimatedTime = MutableLiveData<String>()
    var estimatedTime: LiveData<String> = _estimatedTime

    private val _image = MutableLiveData<Int>()
    var image: LiveData<Int> = _image

    fun setQuantity(numberCoffes: Int) {
        if (numberCoffes == 0) {
            _quantity.value = 1
        }
        _quantity.value = numberCoffes
        updatePrice()
    }

    fun setDescription(summary: String) {
        _description.value = summary
    }

    fun setName(Coffee: String) {
        _name.value = Coffee
    }

    fun setImage(imageCoffee: Int) {
        _image.value = imageCoffee
    }
    fun setEstimatedTime(time: String) {
        _estimatedTime.value = time
    }

     fun updatePrice() {
        var price = (quantity.value ?: 0) * PRICE_PER_COFFEE
        _price.value = price
    }

    init {
        resetOrder()
    }

    fun resetOrder() {
        _quantity.value = 0
        _price.value = 0.0
        _name.value = ""
        _estimatedTime.value = ""
        _description.value = ""
        _image.value = R.drawable.black_coffee
    }
}