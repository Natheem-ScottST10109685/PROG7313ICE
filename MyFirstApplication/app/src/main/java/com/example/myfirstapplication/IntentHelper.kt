package com.example.myfirstapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle


class IntentHelper {
    fun openIntent(context: Context, order: String, activityToOpen: Class<*>){
        // Declare intent with context and class to pass the value to
        val intent = Intent(context, activityToOpen)
        // Pass through the string value with key "order
        intent.putExtra("order", order)
        // If context is not an activity, add FLAG_ACTIVITY_NEW_TASK
        if(context !is android.app.Activity){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        // Start the activity
        context.startActivity(intent)
    }

    fun shareIntent(context: Context, order: String) {
        val sendIntent = Intent()
        // Set the action to indicate what to do - send in this case
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, order)  // Changed from EXTRA_INTENT to EXTRA_TEXT
        // We are sending plain text
        sendIntent.type = "text/plain"
        // Show the share sheet
        val shareIntent = Intent.createChooser(sendIntent, null)  // Changed variable name to shareIntent
        // If context is not an activity, add FLAG_ACTIVITY_NEW_TASK
        if (context !is android.app.Activity) {
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(shareIntent)
    }

    fun shareIntent(context: Context, order: Order){
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND

        // Create a bundle and add multiple values to it
        val shareOrderDetails = Bundle()
        shareOrderDetails.putString("productName", order.productName)
        shareOrderDetails.putString("customerName", order.customerName)
        shareOrderDetails.putString("customerCell", order.customerCell)

        // Share the whole bundle
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails)
        sendIntent.type = "text/plain"

        val shareIntent = Intent.createChooser(sendIntent, null)
        // If context is not an activity, add FLAG_ACTIVITY_NEW_TASK
        if (context !is android.app.Activity){
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(shareIntent)


    }

}