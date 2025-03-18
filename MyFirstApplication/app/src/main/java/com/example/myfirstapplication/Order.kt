package com.example.myfirstapplication

// Add an empty primary constructor
class Order() {
    lateinit var productName: String
    lateinit var customerName: String
    lateinit var customerCell: String
    lateinit var orderDate: String

    // Now this works because it can delegate to the primary constructor
    constructor(pName : String) : this() {
        productName = pName
    }

    constructor(pName: String, cName: String, cCell: String, oDate: String) : this(pName) {
        customerName = cName
        customerCell = cCell
        orderDate = oDate
    }
}