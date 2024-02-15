package com.example.books

open class Book(title: String ,author: String) {

    open fun readPage() {
        currentPage() + 1
    }

    private fun currentPage(): Int {
        return  + 1
    }

}

class eBook(text: String): Book() {
override fun readPage()
}
}