package com.hulk.justcaffe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        price_result_text_view.text = getString(R.string.price_result, totalPrice.toString())

        quantity_plus_button.setOnClickListener {
            quantity += 1
            quantity_text_view.text = quantity.toString()
        }
        quantity_minus_button.setOnClickListener {
            quantity -= 1
            if (quantity < 0)
                quantity = 0
            quantity_text_view.text = quantity.toString()
        }

        submit_button.setOnClickListener {
            calculatePrice()
            price_result_text_view.text = getString(R.string.price_result, totalPrice.toString())
        }

        order_button.setOnClickListener {
            var to = "happycaffe@gmail.com"
            var subject = "Order Caffe"
            var massage =
                "Hi, \n I want to order " + quantity + " cups caffe. \n Total price is " + totalPrice + " dollars. \n " + customer_name_edit_text.text
            val intent = Intent(Intent.ACTION_SEND)
            val address = arrayOf(to)
            intent.putExtra(Intent.EXTRA_EMAIL, address)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, massage)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Send Email using:"))
        }
    }

    var quantity = 0
    var totalPrice = 0

    private fun calculatePrice() {
        var basePrice = 5
        if (ice_cream_check_box.isChecked)
            basePrice += 5
        if (milk_check_box.isChecked)
            basePrice += 5
        if (yogurt_check_box.isChecked)
            basePrice += 5
        if (chocolate_check_box.isChecked)
            basePrice += 5
        totalPrice = quantity * basePrice
    }
}
