package com.madhan.listdemo.model

import com.google.gson.annotations.Expose

class AboutCanada {
    @Expose
    public var title: String? = ""
        get() = field
        set(value) {
            field = value
        }
    @Expose
    public var rows: List<ListModel>? = ArrayList()
        get() = field
        set(value) {
            field = value
        }
}